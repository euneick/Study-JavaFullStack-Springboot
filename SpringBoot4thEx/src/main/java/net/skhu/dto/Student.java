package net.skhu.dto;

import lombok.Data;

@Data
public class Student {

	private String studentNo;
	private String name;
	private int departmentId;
	private String gender;
	private boolean absense;
	private int year;
}
