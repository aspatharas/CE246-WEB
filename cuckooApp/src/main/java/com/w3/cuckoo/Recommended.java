package com.w3.cuckoo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Recommended {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recommended_id;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRecommended_id() {
		return recommended_id;
	}
	public void setRecommended_id(int recommended_id) {
		this.recommended_id = recommended_id;
	}
}