package com.biplav.cp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fa")
public class ForumAnswer {

	@Id
	@GeneratedValue
	private int aid;
	
	@Column
	private String fusername;
	
	@Column
	private String fdate;
	
	@Column(length=500)
	private String answer;
	
	@Column
	private int fq_id;
	
	
//	@ManyToOne
//	@JoinColumn(name="fq_id")
//	private ForumQuestion forumquestion;
	
	
public int getFq_id() {
		return fq_id;
	}
	public void setFq_id(int fq_id) {
		this.fq_id = fq_id;
	}
	//	public ForumQuestion getForumquestion() {
//		return forumquestion;
//	}
//	public void setForumquestion(ForumQuestion forumquestion) {
//		this.forumquestion = forumquestion;
//	}
	public int getId() {
		return aid;
	}
	public void setId(int aid) {
		this.aid = aid;
	}
	public String getUsername() {
		return fusername;
	}
	public void setUsername(String fusername) {
		this.fusername = fusername;
	}
	public String getDate() {
		return fdate;
	}
	public void setDate(String fdate) {
		this.fdate = fdate;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
}
