package com.biplav.cp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="follow")
public class Followers {
	
	@Id
	@GeneratedValue
	private int id;
	@Column
	private int userfollow;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getUserfollow() {
		return userfollow;
	}

	public void setUserfollow(int userfollow) {
		this.userfollow = userfollow;
	}
	

}
