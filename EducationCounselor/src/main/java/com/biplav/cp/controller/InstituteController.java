package com.biplav.cp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.biplav.cp.daos.InstituteDao;
import com.biplav.cp.daos.UserDao;
import com.biplav.cp.models.Institute;
import com.biplav.cp.models.User;

@Controller
public class InstituteController {
	@Autowired
	
	private InstituteDao idao;
	
	@RequestMapping(value="/addinstitute")
	public String viewForm( HttpSession session, Model m)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		
		m.addAttribute("username", session.getAttribute("id"));
		
		return "institute";
	}
	
	@RequestMapping(value="/addinstitute", method=RequestMethod.POST)
	public String addInstitute(@ModelAttribute Institute i, Model m, HttpSession session,  HttpServletRequest req, @RequestParam("file[]") CommonsMultipartFile[] file)
	{		
String path=session.getServletContext().getRealPath("/");
		
		for (CommonsMultipartFile f:file) //for loop not
		{
			String extension = FilenameUtils.getExtension(f.getOriginalFilename());

			if (extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png"))
			{
				
				String filename=f.getOriginalFilename();
				System.out.println(path+" "+filename);
				//System.out.println(rootLocation);
				
				
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println(dir.getAbsolutePath());
				
				if (!dir.exists())
					dir.mkdirs();
				
				/*
				File theDir = new File(path+"/resources/images");
				
				if (!theDir.exists()) 
					theDir.mkdir();
					*/
				
				try
				{
					byte barr[]=f.getBytes();
					
					/*
					  if(Files.copy(f.getInputStream(), this.rootLocation.resolve(filename),StandardCopyOption.REPLACE_EXISTING)>0)
					  {
						  
					  }
					  */
								  
					BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/resources/ins_images/"+filename));
					//BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(dir.getAbsolutePath()+File.separator+filename));
					Object o=bout;
					bout.write(barr);
					bout.flush();
					bout.close();
					
				 System.out.println(filename);
				 i.setImage(filename);
				 	
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		
		
		idao.addInstitute(i);
		m.addAttribute("ilist", idao.getAll());
		m.addAttribute("id1", session.getAttribute("id"));

		return "viewall";
	}
	
	@RequestMapping(value="/allinstitute")
	public String viewAllOpen(User u, Model m, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		m.addAttribute("ilist", idao.getAll());

		m.addAttribute("username", session.getAttribute("id"));
		
		
		return "viewall";
	}
	
	
	@RequestMapping(value="/{id}/deleteIns")
	public String deleteInstitute(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		idao.deleteInstitute(id);
		model.addAttribute("ilist", idao.getAll());
		
		return "viewall";
	}
	
	@RequestMapping(value="/{id}/editIns")
	public String editInstitute(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		model.addAttribute("byid", idao.getById(id));
		
		return "editInstitute";
	}
	
	
	@RequestMapping(value="/updateInstitute", method=RequestMethod.POST)
	public String updateInstitute(HttpSession session, @ModelAttribute Institute i,Model m )
	{
		
		idao.updateInstitute(i);
		
		m.addAttribute("ilist", idao.getAll());
		return "viewall";
	}
	
	@RequestMapping(value="/imageins", method=RequestMethod.POST)
	public String updateImage(@ModelAttribute Institute i, Model m, HttpSession session,  HttpServletRequest req, @RequestParam("file[]") CommonsMultipartFile[] file)
	{
		
String path=session.getServletContext().getRealPath("/");
		
		for (CommonsMultipartFile f:file) //for loop not
		{
			String extension = FilenameUtils.getExtension(f.getOriginalFilename());

			if (extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png"))
			{
				
				String filename=f.getOriginalFilename();
				System.out.println(path+" "+filename);
				//System.out.println(rootLocation);
				
				
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				System.out.println(dir.getAbsolutePath());
				
				if (!dir.exists())
					dir.mkdirs();
				
				/*
				File theDir = new File(path+"/resources/images");
				
				if (!theDir.exists()) 
					theDir.mkdir();
					*/
				
				try
				{
					byte barr[]=f.getBytes();
					
					/*
					  if(Files.copy(f.getInputStream(), this.rootLocation.resolve(filename),StandardCopyOption.REPLACE_EXISTING)>0)
					  {
						  
					  }
					  */
								  
					BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/resources/ins_images/"+filename));
					//BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(dir.getAbsolutePath()+File.separator+filename));
					Object o=bout;
					bout.write(barr);
					bout.flush();
					bout.close();
					
				 System.out.println(filename);
				 i.setImage(filename);
				 	
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		
idao.updateInstitute(i);
		
		m.addAttribute("ilist", idao.getAll());
		return "viewall";
	}
	

	@RequestMapping(value="adminDashborad")
	public String OpenDashborad(HttpSession session, Model m)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		m.addAttribute("username", session.getAttribute("id"));
		
		return "home";
	}
	
	

}
