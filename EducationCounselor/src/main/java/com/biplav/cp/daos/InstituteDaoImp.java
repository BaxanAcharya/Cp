package com.biplav.cp.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biplav.cp.models.Institute;


@Repository
public class InstituteDaoImp implements InstituteDao{

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addInstitute(Institute i) {
		Session session=sessionFactory.getCurrentSession();
		session.save(i);
		
	}

	@Override
	@Transactional
	public void deleteInstitute(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Institute i=(Institute) session.get(Institute.class, id);
		session.delete(i);
		
	}

	@Override
	@Transactional
	public void updateInstitute(Institute i) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		session.update(i);
		
	}

	@Override
	@Transactional
	public Institute getById(int id) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		Institute ins=(Institute) session.get(Institute.class, id);
		return ins;
	}

	@Override
	@Transactional
	public List<Institute> getAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(Institute.class);
		List<Institute> ilist=crt.list();
		return ilist;
	}

}
