package com.biplav.cp.daos;

import java.util.List;

import com.biplav.cp.models.ForumAnswer;
import com.biplav.cp.models.ForumQuestion;

public interface ForumDao {

	
	public List<ForumQuestion> getAllQuestion();
	public void addQuestion(ForumQuestion q);
	
	public List<ForumQuestion> getAll();
	public ForumQuestion getById(int id);
	
	public void addAnswer(ForumAnswer a);
	
	public List<ForumAnswer> getAllAswerById(int id);
}
