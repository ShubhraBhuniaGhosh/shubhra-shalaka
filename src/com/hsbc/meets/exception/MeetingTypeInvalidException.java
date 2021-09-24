package com.hsbc.meets.exception;

public class MeetingTypeInvalidException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Meeting type is compalsary and should be one of the types listed.";
	}
}
