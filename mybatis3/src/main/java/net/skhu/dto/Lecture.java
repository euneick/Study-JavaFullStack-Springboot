package net.skhu.dto;

import lombok.Data;

@Data
public class Lecture {

	private int id;
	private String title;
	private int professorId;
	private int year;
	private String semester;
	private String room;
}
