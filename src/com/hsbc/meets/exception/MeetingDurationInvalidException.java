package com.hsbc.meets.exception;

public class MeetingDurationInvalidException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Duration of the meeting should be atleast 30 min long and atmost 540 min long.";
	}
}
