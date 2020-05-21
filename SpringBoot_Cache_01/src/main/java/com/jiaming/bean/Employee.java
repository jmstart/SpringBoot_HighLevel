package com.jiaming.bean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Employee implements Serializable {
	
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender; //性别 1男  0女
	private Integer dId;

	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, Integer gender, Integer dId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dId = dId;
	}
	
}
