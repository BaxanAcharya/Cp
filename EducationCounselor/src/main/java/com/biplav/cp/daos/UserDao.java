package com.biplav.cp.daos;

import java.util.List;

import com.biplav.cp.models.User;

public interface UserDao {

	public void userRegister(User u);
	public int userLogin(String un, String pwd, String type);
	
	
	public void deleteUser(int id);
	public void updateUser(User s);
	public User getById(int id);
	public List<User> getAll();
}
