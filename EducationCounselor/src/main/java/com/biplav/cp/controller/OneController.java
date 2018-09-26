package com.biplav.cp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OneController {

	@RequestMapping(value="/one")
	public String openController(Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}

		return "one";
	}
	
	
	
}
