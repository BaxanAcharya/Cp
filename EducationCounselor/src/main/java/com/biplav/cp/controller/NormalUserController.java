package com.biplav.cp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biplav.cp.daos.InstituteDao;
import com.biplav.cp.daos.UserDao;
import com.biplav.cp.models.User;

@Controller
public class NormalUserController {
	
	@Autowired
	private InstituteDao idao;
	private UserDao udao;
	
	
	@RequestMapping(value="/userIndex")
	public String openUserIndex(HttpSession session, User u, Model m)
	{
		if(StringUtils.isEmpty(session.getAttribute("nid"))){
			return "login";
		}
String id=(String) session.getAttribute("nid");

m.addAttribute("allInstitute", idao.getAll());
		
		m.addAttribute("au", id);

		return "userview";
		
	}
	
	@RequestMapping(value="/normalProfile")
	public String openProfile(HttpSession session, Model m)
	{
		if(StringUtils.isEmpty(session.getAttribute("nid"))){
			return "login";
		}
		
		int id= (int) session.getAttribute("nai");
		System.out.println(id);
		m.addAttribute("nup", udao.getById(id));
		
		return "normalProfile";
	}

}
