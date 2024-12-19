package net.skhu.dto;

import lombok.Data;

@Data
public class Sugang {

	private int id;
	private int lectureId;
	private int studentId;
	private boolean repeated;
	private boolean cancel;
	private String grade;

	private Student student;
	private Lecture lecture;
}
