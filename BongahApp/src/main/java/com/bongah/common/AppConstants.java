package com.bongah.common;

public class AppConstants
{
	public static int HTTP_PORT = 8080;
	public static int HTTPS_PORT = 8443;
	public static final int MAX_USER_LOGIN_CAPACITY = 500;
	public static final long USER_SESSION_TIMEOUT_IN_MILLIS = 20 * 60 * 1000;
	public static final String KEY_LOGIN_URL = "loginURL";
	public static final String VALUE_LOGIN_URL = "https://localhost:8443/secure/login";
}
