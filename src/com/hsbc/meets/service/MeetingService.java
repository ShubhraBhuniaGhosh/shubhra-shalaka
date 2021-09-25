package com.hsbc.meets.service;

import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
import com.hsbc.meets.exception.MeetingDurationInvalidException;
import com.hsbc.meets.exception.MeetingStartDateTimeInvalidException;
import com.hsbc.meets.exception.MeetingTitleInvalidException;
import com.hsbc.meets.exception.MeetingTypeInvalidException;
import com.hsbc.meets.exception.NotEnoughCreditsException;

public interface MeetingService {
	public void setMeetingBookingInformationInLocalObject(String meetingTitle,Calendar startDateTime,Calendar endDateTime, int durationInMinuts,String meetingType) throws MeetingTitleInvalidException, MeetingStartDateTimeInvalidException, MeetingDurationInvalidException, MeetingTypeInvalidException;
	public List<User> getAllUsers();
	public void setAttendeesListInLocalObject(List<User> attendees);
	public List<MeetingRoom> getAllAvailableMeetingRooms();
	public void setBookedMeetingRoomInLocalObject(MeetingRoom meetingRoom);
	public int bookMeeting(MeetingRoom meetingRoom) throws NotEnoughCreditsException;
}