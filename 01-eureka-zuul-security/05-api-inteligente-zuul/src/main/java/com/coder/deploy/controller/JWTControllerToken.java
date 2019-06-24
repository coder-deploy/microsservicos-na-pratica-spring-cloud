package com.coder.deploy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.filters.PreFilter;

@RestController
public class JWTControllerToken {

	@GetMapping("/token")
	public String getToken() {
		return PreFilter.tokenCreated;
	}
	
}
