package com.coder.deploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;
	
	public ResponseEntity<String> getOla(){
		return restTemplate.getForEntity("http://eureka-client/api-client/ola", String.class);
	}
}
