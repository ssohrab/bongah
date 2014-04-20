package com.bongah.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bongah.common.AppConstants;


public class SecurityFilter implements Filter
{

	@Override
	public void destroy()
	{
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest httpRequest = (HttpServletRequest)request;

		// Make sure "/secure/*" contents are accessed via HTTPS only.
		String relativePath = httpRequest.getRequestURI().toString();
		
		if (relativePath == null)
		{
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			return;
		}

		if (relativePath.startsWith("/secure"))
		{
			if (!httpRequest.isSecure()) 
			{
				// throw unauthorized access error
				((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
				
				return;
			}
		}
		else
		{
			// Any resource accessed outside of "/secure" should go over http, not https.
			// Redirect to http if https is being used
			if (httpRequest.isSecure())
			{
				String redirectURL = ((HttpServletRequest)request).getRequestURL().toString();
				redirectURL = redirectURL.replaceAll("https", "http");
				redirectURL = redirectURL.replaceFirst(Integer.toString(AppConstants.HTTPS_PORT), Integer.toString(AppConstants.HTTP_PORT));

				//((HttpServletResponse)response).sendRedirect(redirectURL);
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		
	}
}
