package com.biplav.cp.daos;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biplav.cp.models.User;


@Repository
//@Repository is an annotation that marks the specific class
//as a Data Access Object, thus clarifying it's role.
//it is used to talk with database

//@Repository: This is also a spring-framework's annotation.
//When you annotate a class @Repository,
//spring container understands it's a DAO class
//and translates all unchecked exceptions (thrown from DAO methods) into
//Spring DataAccessException. DAO class is the class
//where you write methods to perform operations over db.


public class UserDaoImp implements UserDao{
	@Resource
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional //using this we don't have to user commit or execute query
	public void userRegister(User u) {
		Session session=sessionFactory.getCurrentSession();
		session.save(u);
		
	}

	@Override
	@Transactional
	public int userLogin(String un, String pwd, String type) {
		Session session=sessionFactory.getCurrentSession();
		Criteria crt = session.createCriteria(User.class);
		crt.add(Restrictions.eq("username", un)).add(Restrictions.eq("password", pwd)).add(Restrictions.eq("usertype", type));
		
		User u=(User) crt.uniqueResult();
		
		if(u!= null)
		{
			return u.getId();
		}
		
		return 0;
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		User u=(User) session.get(User.class, id);
		session.delete(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		session.update(u);
	}

	@Override
	@Transactional
	public User getById(int id) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		User u=(User) session.get(User.class, id);
		return u;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(User.class);
		List<User> list=crt.list();
		return list;
	}

}
