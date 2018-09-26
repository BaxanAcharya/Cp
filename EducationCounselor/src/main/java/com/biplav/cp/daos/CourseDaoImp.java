package com.biplav.cp.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biplav.cp.models.Course;
import com.biplav.cp.models.Institute;


@Repository
public class CourseDaoImp implements CourseDao{

	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addCourse(Course c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(c);
	}

	@Override
	@Transactional
	public void deleteCourse(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Course c=(Course) session.get(Course.class, id);
		session.delete(c);
		
	}

	@Override
	@Transactional
	public void updateCourse(Course c) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.update(c);
		
	}

	@Override
	@Transactional
	public Course getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
	Course c=	(Course) session.get(Course.class, id);
		return c;
	}

	@Override
	@Transactional
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(Course.class);
		List<Course> clist=crt.list();
		return clist;
		
	}

}
