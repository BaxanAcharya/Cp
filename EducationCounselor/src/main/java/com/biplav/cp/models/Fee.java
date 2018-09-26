package com.biplav.cp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fee")
public class Fee {

	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String resourceFee;
	
	@Column
	private String labFee;
	
	@Column
	private String ECA;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceFee() {
		return resourceFee;
	}
	public void setResourceFee(String resourceFee) {
		this.resourceFee = resourceFee;
	}
	public String getLabFee() {
		return labFee;
	}
	public void setLabFee(String labFee) {
		this.labFee = labFee;
	}
	public String getECA() {
		return ECA;
	}
	public void setECA(String eCA) {
		ECA = eCA;
	}
	
	
}
