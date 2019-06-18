package com.coder.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.service.RibbonService;

@RestController
@RequestMapping("/api-ribbon")
public class RibbonController {
	
	@Autowired
	private RibbonService ribbonService;
	
	@GetMapping("/ola")
	public ResponseEntity<String> getOlaRibbon(){
		return ribbonService.getOla();
	}

}
