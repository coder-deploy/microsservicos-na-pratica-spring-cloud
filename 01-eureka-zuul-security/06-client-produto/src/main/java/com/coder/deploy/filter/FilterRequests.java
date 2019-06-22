package com.coder.deploy.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coder.deploy.util.DecodedTokenJWT;
import com.coder.deploy.util.Util;
 

@Component
public class FilterRequests implements Filter{

	private static final String HEADER_AUTHORIZATION = "Authorization";
	private static final Logger logger = LoggerFactory.getLogger(FilterRequests.class);
	
	@Autowired
	private Util util;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (req.getHeader(HEADER_AUTHORIZATION) == null) {
			logger.warn("************* Nulo o header authorization *************");
		} else {
			logger.warn(req.getHeader(HEADER_AUTHORIZATION));
			DecodedTokenJWT tokenDecoded = new DecodedTokenJWT().getDecoded(req.getHeader(HEADER_AUTHORIZATION));
			logger.warn("User logado: " + tokenDecoded.sub);
			logger.warn("Exp: " + tokenDecoded.exp);
			if (tokenDecoded.exp < util.millisecondsToSeconds(new Date().getTime())) {
				res.sendError(401, "É preciso autenticar!");
			}
		}
		chain.doFilter(request, response);
		
	}
	
	
}
