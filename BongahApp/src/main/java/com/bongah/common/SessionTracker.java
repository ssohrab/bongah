package com.bongah.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class SessionTracker 
{
	private Map<String, UserSessionInfo> sessionsMap;
	
	public SessionTracker() 
	{
		sessionsMap = new HashMap<String, UserSessionInfo>();
	}
	
	public Map<String, UserSessionInfo> getSessionsMap()
	{
		return sessionsMap;
	}
	
	/**
	 * Adds a user session with key being the email address.
	 * 
	 * @param sessionKey
	 * @param info
	 */
	public void addUserSession(String sessionKey, UserSessionInfo info)
	{
		sessionsMap.put(sessionKey, info);
	}
	
	public void removeUserSession(String sessionKey) 
	{
		sessionsMap.remove(sessionKey);
	}

	public UserSessionInfo getUserSessionInfo(String sessionKey)
	{
		return sessionsMap.get(sessionKey);
	}
}
