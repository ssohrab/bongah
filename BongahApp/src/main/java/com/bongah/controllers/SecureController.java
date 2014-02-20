package com.bongah.controllers;

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

import com.bongah.common.SessionTracker;
import com.bongah.common.UserSessionInfo;

@Controller
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private SessionTracker sessionTracker;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		// NOTE: password will be hashed before getting sent from the client side.
		// Authenticate & authorize the user
		// TODO: do it
		int userId = 1;
		
		// Assign a GUID to this user and put him in the sessions map
		// TODO: do it
		String sessionId = UUID.randomUUID().toString();
		
		UserSessionInfo newInfo = new UserSessionInfo();
		newInfo.setLoggedIn(true);
		newInfo.setUserId(userId);
		newInfo.setSessionId(sessionId);
		
		sessionTracker.addUserSession(sessionId, newInfo);

		return "SUCCESS";
	}
}
