package com.coder.deploy.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coder.deploy.util.Util;
 

@Component
public class FilterRequests implements Filter{

	private static final Logger logger = LoggerFactory.getLogger(FilterRequests.class);
	
	@Autowired
	private Util util;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.warn("Validando token...");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
	    String token = restTemplate.exchange("http://localhost:9090/token", HttpMethod.GET, entity, String.class).getBody();
	    util.validationToken(token);
	    logger.warn("Token validado com sucesso!");
		chain.doFilter(request, response);
		
	}
	
	
}
