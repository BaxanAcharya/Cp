package com.biplav.cp.daos;

import java.util.List;

import com.biplav.cp.models.Institute;



public interface InstituteDao {

	public void addInstitute(Institute i);
	public void deleteInstitute(int id);
	public void updateInstitute(Institute s);
	public Institute getById(int id);
	public List<Institute> getAll();
}
