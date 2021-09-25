package com.hsbc.meets.service.impl;

import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.dao.impl.MeetingDbDaoImpl;
import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingRoomAmenitiesInvalidByMeetingTypeException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.exception.NotEnoughCreditsException;
import com.hsbc.meets.service.MeetingService;
import com.hsbc.meets.validation.MeetingBookingValidation;

/**
 * This class implements {@link MeetingService}
 * @author tells
 *
 */
public class MeetingServiceImpl implements MeetingService{
	private User Manager;
	private Meeting bookedMeeting;
	private MeetingDao dao;
	/**
	 * @author ShubhraBhuniaGhosh
	 * @param Manager
	 */
	public  MeetingServiceImpl(User Manager){
		this.Manager = Manager;
		dao = new MeetingDbDaoImpl();
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean setMeetingBookingInformation(String meetingTitle,Calendar startDateTime,Calendar endDateTime, int durationInMinuts,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException {
		if(MeetingBookingValidation.validateMeetingInformation(this.dao, meetingTitle, startDateTime, durationInMinuts, meetingType)) {
			this.bookedMeeting = new Meeting(meetingTitle, startDateTime, durationInMinuts, meetingType);
			endDateTime.add(Calendar.MINUTE, durationInMinuts);
			bookedMeeting.setEndDateTime(endDateTime);
		}
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public List<User> getAllUsers() {
		return dao.getAllUsers();
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean setAttendeesList(List<User> attendees){
		bookedMeeting.setAttendees(attendees);
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public List<MeetingRoom> getAllAvailableMeetingRooms() {
		return dao.getMeetingRoomsConditionsApplied(bookedMeeting.getStartDateTime(), bookedMeeting.getDurationInMinuts(), bookedMeeting.getAttendees().size());
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 * @throws MeetingRoomAmenitiesInvalidException 
	 */
	public boolean setBookedMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAmenitiesInvalidByMeetingTypeException{
		if(dao.checkAmenitiesPresentByMeetingRoomName(meetingRoom.getMeetingRoomName())) {
			bookedMeeting.setMeetingRoom(meetingRoom);
			return true;
		}
		else
			throw new MeetingRoomAmenitiesInvalidByMeetingTypeException();
		
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public int bookMeeting() throws NotEnoughCreditsException {
		int totalRowsUpdated = 0;
		if(!dao.checkManagerCredits(this.Manager.getUserId())) {
			throw new NotEnoughCreditsException();
		}
		int meetingId = dao.insertValueOfMeeting(this.bookedMeeting);
		totalRowsUpdated+=1;
		totalRowsUpdated+=dao.addAttendees(bookedMeeting.getAttendees(),meetingId);
		totalRowsUpdated+=dao.deductManagerCreditByMeetingRoomName(bookedMeeting.getMeetingRoom().getMeetingRoomName(),this.Manager.getUserId());
		return totalRowsUpdated;
	}
	
}
