package com.biplav.cp.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.biplav.cp.daos.UserDao;
import com.biplav.cp.models.User;


@Controller
public class UserController {
	
	@Autowired
	private UserDao udao;
	
	
	@RequestMapping(value="/user")
	public String  getUser(Model m,HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		
		m.addAttribute("ulist", udao.getAll());
		m.addAttribute("username", session.getAttribute("id"));
		return "user";
		
	}
	
	@RequestMapping(value="/userProfile")
	public String  getProfile(Model m,HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		
		int id=(Integer) session.getAttribute("activeUserID");
	
		m.addAttribute("getUser", udao.getById(id));
		return "profile";
		
	}
	
	@RequestMapping(value="/{id}/deleteUser")
	public String deleteUser(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		udao.deleteUser(id);
		model.addAttribute("ulist", udao.getAll());
		model.addAttribute("username", session.getAttribute("id"));
		return "user";
	}
	
	@RequestMapping(value="/{id}/editUser")
	public String editUser(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		model.addAttribute("byidUser", udao.getById(id));
		model.addAttribute("username", session.getAttribute("id"));
		
		return "editUser";
	}
	
	
	@RequestMapping(value="/editUserb",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String updateUser(@ModelAttribute User u,Model model){
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		udao.updateUser(u);
		model.addAttribute("ulist", udao.getAll());
		return "user";
	}
	
	
	
	@RequestMapping(value="/editUserImg",method=RequestMethod.POST)
	//model attribute is used to bind the multiple value and carries that data
	public String UpdateUserImg(@ModelAttribute User u, HttpServletRequest req, Model model,@RequestParam("file[]") CommonsMultipartFile[] file, HttpSession session){
		
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
								  
					BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/resources/images/"+filename));
					//BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(dir.getAbsolutePath()+File.separator+filename));
					Object o=bout;
					bout.write(barr);
					bout.flush();
					bout.close();
					
				 System.out.println(filename);
				 u.setImage(filename);
				 	
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		}
		
		udao.updateUser(u);
		model.addAttribute("getUser", udao.getById((int) session.getAttribute("activeUserID")));
		return "profile";
	}
	
	
	@RequestMapping(value="/userProfile", method=RequestMethod.POST)
	public String updateProfile(@ModelAttribute User u, Model model, HttpSession session)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		udao.updateUser(u);
		
		model.addAttribute("ulist", udao.getAll());
		
		return "user";
	}
	
	
	@RequestMapping(value="/adduser")
	public String openAddUser(HttpSession session, Model m)
	{
		if(StringUtils.isEmpty(session.getAttribute("id"))){
			return "login";
		}
		m.addAttribute("username", session.getAttribute("id"));
		return "addUser";
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute User u, HttpServletRequest req, Model m,@RequestParam("file[]") CommonsMultipartFile[] file, HttpSession session) throws IOException
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
								  
					BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(path+"/resources/images/"+filename));
					//BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(dir.getAbsolutePath()+File.separator+filename));
					Object o=bout;
					bout.write(barr);
					bout.flush();
					bout.close();
					
				 System.out.println(filename);
				 u.setImage(filename);
				 	
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
			else
			{
				m.addAttribute("ex", "File Format not supported!!!!!");
				return "addUser";
			}
		}
		
		
		
		//hashing
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		u.setCount(1);

		udao.userRegister(u);
		m.addAttribute("username", session.getAttribute("id"));
		m.addAttribute("ulist", udao.getAll());
		return "user";
		}
	
	

}

