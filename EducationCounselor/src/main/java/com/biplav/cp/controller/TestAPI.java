package com.biplav.cp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.biplav.cp.models.User;

public class TestAPI {

	
	public static void main(String[] args) {
		//generating object from jason
		
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<User> resp= restTemplate.getForEntity("http://localhost:8082/cp/api/user/1",User.class);
		User u=resp.getBody();
		System.out.println(u.getFirstname()+ " " + u.getLastname());
	}
}
