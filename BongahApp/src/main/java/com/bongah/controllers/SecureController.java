package com.bongah.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bongah.common.AppConstants;
import com.bongah.common.SessionTracker;
import com.bongah.common.UserSessionInfo;
import com.bongah.entities.UserEntity;
import com.bongah.repositories.IUserRepository;

@Controller
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private SessionTracker sessionTracker;

	@Autowired
	private IUserRepository userRepo;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("email") String email,
			@RequestParam("password") String password)
	{
		// NOTE: password will be hashed before getting sent from the client side.

		String sessionId;

		if (isUserLoggedInAndSessionValid(email))
		{
			sessionId = sessionTracker.getUserSessionInfo(email).getSessionId();
		}
		else
		{
			sessionId = performLogin(email, password);
		}

		return sessionId;
	}
	
	private boolean isUserLoggedInAndSessionValid(String email)
	{
		// If the user is logged in, SessionTracker should know
		UserSessionInfo userSessionInfo = sessionTracker.getUserSessionInfo(email);
		
		if(userSessionInfo == null) return false;

		// Check the time of login, and if longer than 20 minutes require login again
		Date currentTime = new Date();
		Date loginTime = userSessionInfo.getLoginTime();

		long diffTime = currentTime.getTime() - loginTime.getTime();

		if (diffTime < AppConstants.USER_SESSION_TIMEOUT_IN_MILLIS) return true;

		return false;
	}

	private String performLogin(String email, String password)
	{
		String sessionId = "failed";
		
		if (isCapacityReached()) return sessionId;
		
		UserEntity user = userRepo.findByEmailAddress(email);
		
		if (user != null)
		{
			if (user.getPassword().compareTo(password) == 0)
			{
				// Assign a GUID to this user and put him in the sessions map
				sessionId = UUID.randomUUID().toString();
				
				UserSessionInfo newInfo = new UserSessionInfo();
				newInfo.setLoggedIn(true);
				newInfo.setUserId(user.getId());
				newInfo.setSessionId(sessionId);
				
				sessionTracker.addUserSession(email, newInfo);
			}
		}

		return sessionId;
	}

	private boolean isCapacityReached()
	{
		if (sessionTracker.getSessionsMap().size() >= AppConstants.MAX_USER_LOGIN_CAPACITY)
		{
			if (attemptOpeningCapacity() == 0)
			{
				return true;
			}
		}
	
		return false;
	}

	/**
	 * This method find all the expired login sessions and removes them from {@link SessionTracker}
	 * 
	 * @return an int indicating how many stale login sessions were removed.
	 */
	private int attemptOpeningCapacity()
	{
		Date currentTime = new Date();
		List<String> keysList = new ArrayList<String>();

		for (String key : sessionTracker.getSessionsMap().keySet())
		{
			UserSessionInfo info = sessionTracker.getUserSessionInfo(key);

			if ((currentTime.getTime() - info.getLoginTime().getTime()) >= AppConstants.USER_SESSION_TIMEOUT_IN_MILLIS) keysList.add(key);
		}

		for (String key : keysList)
		{
			sessionTracker.getSessionsMap().remove(key);
		}
		
		return keysList.size();
	}
}
