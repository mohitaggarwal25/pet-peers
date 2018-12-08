package com.petpeers.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="pets")
@ApiModel(description="All details about the student. ")
public class Pet {
	@Id
	@GeneratedValue
	private Long id;	
	@Column(name="pet_name")
	private String petName;
	@Column(name="pet_age")
	private int petAge;
	@Column(name="pet_place")
	private String petPlace;
	@Column(name="pet_ownerid")
	private User petOwner;
	
	
}
