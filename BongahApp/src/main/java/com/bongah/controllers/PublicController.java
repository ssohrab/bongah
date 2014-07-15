package com.bongah.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bongah.common.AppConstants;
import com.bongah.common.SessionTracker;
import com.bongah.repositories.IUserRepository;

@Controller
public class PublicController 
{	
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private SessionTracker sessionTracker;

	/**
	 * Returns home view, visible to the public.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute(AppConstants.KEY_LOGIN_URL, AppConstants.VALUE_LOGIN_URL);

		return "home";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getTotalUsers")
	@ResponseBody
	public String getTotalUsersInDB(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
	{
		long numOfUsers = userRepo.count();

		return Long.toString(numOfUsers);
	}
}
