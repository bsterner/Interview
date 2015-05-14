package com.reachengine.note.api.model;

import java.io.Serializable;

public class Note implements Serializable {

	private static final long serialVersionUID = -7197758262791327499L;

	private int id;

	private String body;

	public Note() {	
	}
	
	public Note(String body) {
		this.body = body;
	}

	public Note(Integer id, String body) {
		this.id = id;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
