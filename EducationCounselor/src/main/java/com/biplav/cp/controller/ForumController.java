package com.biplav.cp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.biplav.cp.daos.ForumDao;
import com.biplav.cp.models.ForumAnswer;
import com.biplav.cp.models.ForumQuestion;

@Controller
public class ForumController {

	@Autowired
	private ForumDao fdao;
	
	
	@RequestMapping(value="/forum")
	public String openForum( @ModelAttribute ForumQuestion fq, HttpSession session, Model m, HttpServletRequest req)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		
		

		//System.out.println(req.getParameter("fq_id"));
		
		//m.addAttribute("abyid", fdao.getAllQuestion());
		
		m.addAttribute("qlist", fdao.getAll());
		List<ForumQuestion> flist=fdao.getAll();
		
		for(ForumQuestion item:flist){
	      int  id=item.getId();
	        m.addAttribute("faid", fdao.getAllAswerById(id));

	    }
		
		m.addAttribute("username", session.getAttribute("id"));
		return "forum";
	}
	
	
	@RequestMapping(value="/fquestion", method=RequestMethod.POST)
	public String postQuestion(ForumQuestion q, Model m, HttpSession session)
	{
		String un=(String) session.getAttribute("id");
		q.setUsername(un);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		  q.setDate(dtf.format(now));

		fdao.addQuestion(q);
		
		
		m.addAttribute("username", session.getAttribute("id"));
		m.addAttribute("qlist", fdao.getAll());

		return "forum";
	}
	

	
	@RequestMapping(value="/forumAnswer", method=RequestMethod.POST)
	public String postAnswer(HttpSession session, ForumAnswer a, Model m, ForumQuestion f, ServletRequest req)
	{
		
		String un=(String) session.getAttribute("id");
		a.setUsername(un);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		  a.setDate(dtf.format(now));
		//System.out.println(req.getParameter("fid")); 

		
	
//	System.out.println(a.getForumquestion());
//		
//a.setForumquestion((ForumQuestion) fdao.getById(f));
//		
//		  
	 fdao.addAnswer(a);
		  
		  m.addAttribute("username", session.getAttribute("id"));
		  m.addAttribute("qlist", fdao.getAll());
		return "forum";
	}
	
}
