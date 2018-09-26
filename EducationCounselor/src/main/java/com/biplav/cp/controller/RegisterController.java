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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.biplav.cp.daos.UserDao;
import com.biplav.cp.models.User;

@Controller
public class RegisterController {
	

	@Autowired
	private UserDao udao;

	@RequestMapping(value="/register")
	public String viewRegister()
	{
		return "register";
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
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
				return "register";
			}
		}
		
		
		
		//hashing
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		u.setUsertype("normal");
		u.setCount(1);

		udao.userRegister(u);
		return "login";
		}
	
	
	@RequestMapping(value="/adminregister", method=RequestMethod.POST)
	public String AminregisterUser(@ModelAttribute User u, HttpServletRequest req, Model m,@RequestParam("file[]") CommonsMultipartFile[] file, HttpSession session) throws IOException
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
		}
		
		
		
		//hashing
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		u.setCount(1);

		udao.userRegister(u);
		
		m.addAttribute("ulist", udao.getAll());
		return "user";
		}


	}

