package net.skhu.model;

import lombok.Data;

@Data
public class Pagination {

	private int page = 1;
	private int size = 15;
	private int totalRecord;

	public int getFirstRecordIndex() {
		return (page - 1) * size;
	}

	public String getQueryString() {
		return String.format("page=%d&size=%d", page, size);
	}
}
