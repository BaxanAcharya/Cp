package com.biplav.cp.daos;

import java.util.List;

import com.biplav.cp.models.Course;

public interface CourseDao {

	public void addCourse(Course c);
	public void deleteCourse(int id);
	public void updateCourse(Course s);
	public Course getById(int id);
	public List<Course> getAll();
}
