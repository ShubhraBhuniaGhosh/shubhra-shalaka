package com.hsbc.meets.service;


import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.dao.MeetingBookingDao;
import com.hsbc.meets.dao.impl.MeetingBookingDbDaoImpl;
import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.exception.NotEnoughCreditsException;
import com.hsbc.meets.validation.MeetingBookingValidation;

public class MeetingService {
	private User Manager;
	private Meeting bookedMeeting;
	private MeetingBookingDao dao;

	public  MeetingService(User Manager){
		this.Manager = Manager;
		dao = new MeetingBookingDbDaoImpl();
	}
	public void setMeetingBookingInformationInLocalObject(String meetingTitle,Calendar startDateTime,Calendar endDateTime, int durationInMinuts,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException {
		if(MeetingBookingValidation.validateMeetingInformation(this.dao, meetingTitle, startDateTime, durationInMinuts, meetingType)) {
			this.bookedMeeting = new Meeting(meetingTitle, startDateTime, durationInMinuts, meetingType);
			endDateTime.add(Calendar.MINUTE, durationInMinuts);
			bookedMeeting.setEndDateTime(endDateTime);
		}
	}
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	public void setAttendeesListInLocalObject(List<User> attendees){
		bookedMeeting.setAttendees(attendees);
	}
	public List<MeetingRoom> getAllAvailableMeetingRooms() {
		return dao.getMeetingRoomsConditionsApplied(bookedMeeting.getStartDateTime(), bookedMeeting.getDurationInMinuts(), bookedMeeting.getAttendees().size());
	}
	public void setBookedMeetingRoomInLocalObject(MeetingRoom meetingRoom){
		bookedMeeting.setMeetingRoom(meetingRoom);
	}
	public int bookMeeting(MeetingRoom meetingRoom) throws NotEnoughCreditsException {
		int totalRowsUpdated = 0;
		if(!dao.checkManagerCredits(this.Manager.getUserId())) {
			throw new NotEnoughCreditsException();
		}
		int meetingId = dao.insertValueInMeeting(this.bookedMeeting);
		totalRowsUpdated+=1;
		totalRowsUpdated+=dao.addAttendees(bookedMeeting.getAttendees(),meetingId);
		totalRowsUpdated+=dao.deductManagerCreditByMeetingRoomName(meetingRoom.getMeetingRoomName(),this.Manager.getUserId());
		return totalRowsUpdated;
	}
	
}
