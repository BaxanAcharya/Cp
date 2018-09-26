package com.biplav.cp.daos;

import com.biplav.cp.models.Followers;

public interface FollowDao {

	
	public Followers getById(int id);
	public void update(Followers f);
}
