package com.biplav.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.biplav.cp.daos.UserDao;
import com.biplav.cp.models.User;



//this controller shows on jason
@RestController
@RequestMapping("api/user")
public class UserRestAPI {

	@Autowired
	private UserDao udao;
	
	
	@RequestMapping(value="/list")
	public ResponseEntity<List<User>> getAllUser()
	{
		ResponseEntity<List<User>> ulist=new ResponseEntity<List<User>>(udao.getAll(), HttpStatus.OK);
		
		return ulist;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getById(@PathVariable("id")int id){
		ResponseEntity<User> u= new ResponseEntity<User>(udao.getById(id), HttpStatus.OK);
		return u;
		
		
	}
	
	@RequestMapping(value="/currency")
	public ResponseEntity<String> getTodayRate()
	{
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<String> resp= restTemplate.getForEntity("http://api.fixer.io/latest?access_key = 7b754af3d1e88ad5f9308fe551adaf8b & base=USD",String.class);
		
		return resp;
	}
	
}
