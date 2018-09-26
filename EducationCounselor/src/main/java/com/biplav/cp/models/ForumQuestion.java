package com.biplav.cp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fques")
public class ForumQuestion {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String username;
	@Column
	private String date;
	@Column(length=500)
	private String question;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fq_id")
	private List<ForumAnswer> fa=new ArrayList<ForumAnswer>();
	
	
	public List<ForumAnswer> getFa() {
		return fa;
	}
	public void setFa(List<ForumAnswer> fa) {
		this.fa = fa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
