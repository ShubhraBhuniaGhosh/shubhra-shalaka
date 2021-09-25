package com.hsbc.meets.validation;


import java.util.Calendar;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;


public abstract class MeetingBookingValidation {

	public static boolean validateMeetingInformation(MeetingDao dao, String meetingTitle,Calendar startDateTime, int durationInMinuts,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException{
		if(validateMeetingTitle(dao, meetingTitle) && validateMeetingStartDateTime(startDateTime) && validateMeetingDurationInMinuts(durationInMinuts) && validateMeetingMeetingType(meetingType)){
			return true;
		}
		return false;
	}

	private static boolean validateMeetingMeetingType(String meetingType) throws MeetingTypeInvalidException {
		if(meetingType.toLowerCase()=="classroom training" || meetingType.toLowerCase()=="online training " || meetingType.toLowerCase()=="conference call" || meetingType.toLowerCase()=="business") {
			return true;
		}
		throw new MeetingTypeInvalidException();
	}

	private static boolean validateMeetingDurationInMinuts(int durationInMinuts) throws MeetingDurationInvalidException {
		if(durationInMinuts>=30 && durationInMinuts<=540)
			return true;
		throw new MeetingDurationInvalidException();
	}

	private static boolean validateMeetingStartDateTime(Calendar startDateTime) throws MeetingStartDateTimeInvalidException {
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DATE, 1);
		System.out.println(startDateTime.compareTo(today));
		if(startDateTime.compareTo(today)>=0) {
			throw new MeetingStartDateTimeInvalidException();
		}
		return true;
	}

	private static boolean validateMeetingTitle(MeetingDao dao, String meetingTitle) throws MeetingTitleInvalidException {
		if(meetingTitle.length()<4 || meetingTitle.length()>20) {
			throw new MeetingTitleInvalidException();
		}
		meetingTitle = meetingTitle.toLowerCase();
		char[] titleCharacterArray = meetingTitle.toCharArray();
		for (int i = 0; i < titleCharacterArray.length; i++) {
			char ch = titleCharacterArray[i];
			if (!(ch >= 'a' && ch <= 'z') && (ch!=' ')) {
				throw new MeetingTitleInvalidException();
			}
		}
		if(dao.checkMeetingNameAlreadyExists(meetingTitle))
			throw new MeetingTitleInvalidException();
		return false;
	}
	public static void main(String[] args) {
		Calendar someday =  Calendar.getInstance();
		//someday.set(2021, 8, 25, 12, 55);
		//someday.set(2021, 1, 26, 23, 55);
		//someday.add(Calendar.DATE, 1);
		//someday.add(field, amount);

		//new MeetingBookingValidation().validateMeetingStartDateTime(someday);
	}
}
