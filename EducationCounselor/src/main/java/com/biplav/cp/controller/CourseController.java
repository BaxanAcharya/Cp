package com.biplav.cp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biplav.cp.daos.CourseDao;
import com.biplav.cp.daos.InstituteDao;
import com.biplav.cp.models.Course;

@Controller
public class CourseController {
	
	@Autowired
	private CourseDao cdao;
	private InstituteDao idao;
	
	@RequestMapping(value="course")
	public String openCourse(HttpSession session, Model m)
	{if(StringUtils.isEmpty(session.getAttribute("id"))){
		return "login";
	}

	m.addAttribute("username", session.getAttribute("id"));
	
		return "addCourse";
	}
	@RequestMapping(value="addcourse", method=RequestMethod.POST)
	public String addCourse(@ModelAttribute Course c, Model m, HttpSession session)
	{
		cdao.addCourse(c);
		m.addAttribute("clist", cdao.getAll());
		m.addAttribute("username", session.getAttribute("id"));
		return "allCourse";
	}
	
	@RequestMapping(value="allcourse")
	public String viewCorse(Model m)
	{
		m.addAttribute("clist", cdao.getAll());
		return "allCourse";
	}
	
	@RequestMapping(value="/{id}/deleteCourse")
	public String deleteInstitute(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		cdao.deleteCourse(id);
		model.addAttribute("clist", cdao.getAll());
		
		return "allCourse";
	}
	
	@RequestMapping(value="/{id}/editCourse")
	public String editInstitute(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		//model.addAttribute("select", idao.getAll());
		model.addAttribute("byidCourse", cdao.getById(id));
		
		return "editCourse";
	}
	
	@RequestMapping(value="updateCourse", method=RequestMethod.POST)
	public String updateCourse(HttpSession session, Course c, Model m)
	{
		cdao.updateCourse(c);
		m.addAttribute("clist", cdao.getAll());
		return "allCourse";
	}

}
