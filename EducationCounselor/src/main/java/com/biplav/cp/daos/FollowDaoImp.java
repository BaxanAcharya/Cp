package com.biplav.cp.daos;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biplav.cp.models.Followers;
@Repository
public class FollowDaoImp  implements FollowDao{

	@Resource
	private SessionFactory sessionFactory;


	@Override
	@Transactional
	public void update(Followers f) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		session.update(f);
		
	}
	
	@Override
	@Transactional
	public Followers getById(int id) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		Followers follow=(Followers) session.get(Followers.class, id);
		return follow;
	}

}
