package com.csuf;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userposts")
public class Blog {

	@GenericGenerator(name="g1",strategy="increment")
	@Id
	@GeneratedValue(generator="g1")
	private Integer blogID;
	
	private String userName;

	private String title;

	private String description;

	private Date date;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getBlogID() {
		return blogID;
	}

	public void setBlogID(Integer blogID) {
		this.blogID = blogID;
	}
	

}
