package com.kioshq.distro.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/* Can use this class to do something before / after requests and based on user authentication */
public class SessionAuthenticationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			SecurityContext sc = SecurityContextHolder.getContext();
			if (!(sc.getAuthentication() instanceof AnonymousAuthenticationToken)) {

			} else {
				// Can do something else here with the unauthenticated user
			}

		} catch (Exception e) {
			e.getMessage();
		}

		filterChain.doFilter(request, response);
	}
}
