//package com.hsbc.meets.entity;

public class Attendee {
	private int userId;
	private String name;
	
	public Attendee(int userId, String name) {
		this.userId = userId;
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	
	
}