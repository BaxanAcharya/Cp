package com.biplav.cp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biplav.cp.daos.FollowDao;
import com.biplav.cp.daos.UserDao;
import com.biplav.cp.models.Followers;
import com.biplav.cp.models.User;

@Controller
public class LoginController {
	

	@Autowired
	private UserDao udao;
	private FollowDao fdao;



	@RequestMapping(value = "/userlogin")
	public String viewLogin() {
		return "login";
		
		

	}



	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String Login(@ModelAttribute User u, Model model, HttpSession session, HttpServletRequest req)throws IOException {
		
		// Hashing password
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		int id=udao.userLogin(u.getUsername(), u.getPassword(), u.getUsertype());
	
		udao.getById(id);
		
		
		//String google=req.getParameter("g-recaptcha-response");
		//boolean verify=VerifyRecaptcha.verify(google);
		
		//if(verify){
		
		if (id> 0) 
		{
			if(u.getUsertype().equals("normal"))
			{
			
			
				session.setAttribute("nid", u.getUsername());
				session.setAttribute("nai", id);
				model.addAttribute("un", u.getUsername());
				
			
			return "userhome";
			}
			else if(u.getUsertype().equals("admin"))
			{
				session.setAttribute("id", u.getUsername());
				session.setAttribute("activeUserID", id);
				model.addAttribute("username", u.getUsername());
				return "home";
			}
			else
			{
				model.addAttribute("te", "You are teacher!!!");
				return "login";
			}
		}
		
		else{
		model.addAttribute("error", "Username or Password error !!!!!");
		return "login";
		}
		//}
//		else
//		{
//			model.addAttribute("robot", "You are not human !!!!");
//			return "login";
//		}
	}
	
	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin(){
		
		//String secret_key = "c85c3bbaeded9ce1ea6af891cc8733c2";
		//String app_id = "329630870908625";
		
		return "redirect:https://www.facebook.com/dialog/oauth?client_id=1500161760087629&redirect_uri=http://localhost:8082/cp/authorize/facebook&response_type=code&scope=email";
	}
	
	
	
	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request){
		
		
	      return "home";
	      
	      
	      
	      }
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)

	{
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value="follow")
	public String updateFollow(HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		

		
		return "home";
	}
	
	@RequestMapping(value="mapsas")
	public String maps(HttpSession session, Model m)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		m.addAttribute("username", session.getAttribute("id"));
		return "map";
	}
}



