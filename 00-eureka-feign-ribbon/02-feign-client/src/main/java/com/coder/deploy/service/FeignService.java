package com.coder.deploy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface FeignService {
	
	@GetMapping("/api-client/ola")
	ResponseEntity<String> getOla();
	

}
