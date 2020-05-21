package com.jiaming.bean;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {
	
	private Integer id;
	private String departmentName;
	
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
	}

}
