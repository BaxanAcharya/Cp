package com.biplav.cp.daos;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.biplav.cp.models.ForumAnswer;
import com.biplav.cp.models.ForumQuestion;


@Repository
public class ForumDaoImp implements ForumDao{
	
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void addQuestion(ForumQuestion q) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		session.save(q);
		
	}

	@Override
	@Transactional
	public List<ForumQuestion> getAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Criteria crt=session.createCriteria(ForumQuestion.class);
		List<ForumQuestion> qlist=crt.list();
		return qlist;
	}

	@Override
	@Transactional
	public void addAnswer(ForumAnswer a) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.save(a);
		
		
	}

	@Override
	@Transactional
	public List<ForumAnswer> getAllAswerById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery("select * from fa where  fq_id=:value").addEntity(ForumAnswer.class).setParameter("value", id);
		
		List<ForumAnswer> fa=query.list();
		return fa;
	}

	@Override
	@Transactional
	public ForumQuestion getById(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		ForumQuestion fq=(ForumQuestion) session.get(ForumQuestion.class, id);
		return fq;
		
	}

	@Override
	@Transactional
	public List<ForumQuestion> getAllQuestion() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
//		ForumQuestion jobpsterimpl=(ForumQuestion) session.get(ForumQuestion.class, id);
		
//	System.out.println("----------------d324234324 ko lagi ------------");
//	System.out.println(id);


	Query query = session.createSQLQuery("select * from fques\r\n" + 
	 		"inner join fa\r\n" + 
	 		"on fques.id=fa.fq_id");
	/*query.setParameter("value", id);*/
	
/*	addEntity(Postjobs.class).setParameter("value", id)
*/	/*List result = query.list();*/
	List<ForumQuestion> nlist=query.list();
	System.out.println("====================list agi");
	
	return nlist;
	
	}



	

}
