package com.bongah.common;

import java.util.Date;

public class UserSessionInfo
{	
	private int userId;
	private Date loginTime;
	private String sessionId;
	private boolean loggedIn;

	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Date getLoginTime()
	{
		return loginTime;
	}
	
	public void setLoginTime(Date date)
	{
		loginTime = date;
	}

	public String getSessionId() {
		return sessionId;
	}
	
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
}
