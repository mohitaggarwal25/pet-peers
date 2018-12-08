package com.petpeers.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pet_user")
@ApiModel(description="All details about the student. ")
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="user_name")
	private String userName;	
	@ApiModelProperty(notes="Name should have atleast 2 characters")
	@Size(min=2, message="Name should have atleast 2 characters")
	
	@Column(name="user_password")
	private String userPassword;
	
	List<Pet> pets;
	
	public User() {
		super();
	}

	public User(
			Long id,
			String userName,
			@Size(min = 2, message = "Name should have atleast 2 characters") String userPassword) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
}
