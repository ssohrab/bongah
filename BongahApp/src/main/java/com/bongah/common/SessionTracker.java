package com.bongah.common;

import java.util.HashMap;
import java.util.Map;

public class SessionTracker {

	private Map<String, UserSessionInfo> sessionsMap;
	
	public SessionTracker() {
		sessionsMap = new HashMap<String, UserSessionInfo>();
	}
	
	public Map<String, UserSessionInfo> getSessionsMap() {
		return sessionsMap;
	}
	
	public void addUserSession(String sessionKey, UserSessionInfo info) {
		sessionsMap.put(sessionKey, info);
	}
	
	public void removeUserSession(String sessionKey) {
		sessionsMap.remove(sessionKey);
	}
}
