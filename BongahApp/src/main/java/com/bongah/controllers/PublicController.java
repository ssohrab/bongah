package com.bongah.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bongah.common.AppConstants;

@Controller
public class PublicController {
	
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);
	
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

	/**
	 * Returns accountSettings view
	 */
	@RequestMapping(method = RequestMethod.GET, value="/accountSettings")
	public String accountSettings(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
	{
		logger.info("Account settings requested");

		return "accountSettings";
	}
}
