package com.coder.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.service.FeignService;

@RestController
@RequestMapping("/api-feign")
public class FeignController {

	@Autowired
	private FeignService feignService;
	
	@GetMapping("/ola")
	public ResponseEntity<String> getOlaFeign(){
		return feignService.getOla();
	}
}
