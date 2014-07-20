package com.bongah.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bongah.common.AppConstants;
import com.bongah.common.QueryParamKeys;
import com.bongah.common.SessionTracker;
import com.bongah.entities.PropertyEntity;
import com.bongah.entities.UserEntity;
import com.bongah.repositories.IPropertyRepository;
import com.bongah.repositories.IUserRepository;

@Controller
public class PublicController 
{	
	private static final Logger logger = LoggerFactory.getLogger(PublicController.class);

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IPropertyRepository propertyRepo;
	
	@Autowired
	private SessionTracker sessionTracker;

	/**
	 * Returns home view, visible to the public.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String home(HttpServletRequest request, HttpServletResponse response, Locale locale, Model model)
	{
		
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

	@RequestMapping(method = RequestMethod.GET, value="/getPropertyByRef")
	@ResponseBody
	public String getPropertyByReferenceNumber(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(QueryParamKeys.KEY_QUERY_PARAM_PROPERTY_REF) final int refNumber)
	{
		PropertyEntity pe = propertyRepo.findByPropertyReferenceNumber(refNumber);
		
		return pe.getCityName();
	}

	@Transactional
	@RequestMapping(method = RequestMethod.GET, value="/getAllUsers")
	@ResponseBody
	public String getUserAllUsers(HttpServletRequest request, HttpServletResponse response)
	{
		String result = "";
		Iterable<UserEntity> users = userRepo.findAll();
		
		if (users != null)
		{
			Iterator<UserEntity> userIterator = users.iterator();
			
			while (userIterator.hasNext())
			{
				UserEntity ue = userIterator.next();
				//Hibernate.initialize(ue.getProperties());
				result = "User id = " + ue.getId() + ", Ref num = " + ue.getProperties().get(0).getPropertyReferenceNumber();
				logger.info(result);
			}
		}

		return result;
	}
}
