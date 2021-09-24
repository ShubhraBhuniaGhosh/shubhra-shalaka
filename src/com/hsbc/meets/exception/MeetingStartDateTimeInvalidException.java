package com.hsbc.meets.exception;

public class MeetingStartDateTimeInvalidException extends Exception {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Meeting start date and time should have more than 24 hours of difference from date and time of booking";
	}
}
