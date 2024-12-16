package net.skhu.dto;

import lombok.Data;

@Data
public class Student {

	private int id;
	private String studentNo;
	private String name;
	private int departmentId;
	private String phone;
	private String sex;
	private String email;

	private String departmentName;
}
