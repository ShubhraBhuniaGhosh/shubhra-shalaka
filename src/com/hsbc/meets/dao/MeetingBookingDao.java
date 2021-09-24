package com.hsbc.meets.dao;

import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;

public interface MeetingBookingDao {
	public List<MeetingRoom> getMeetingRoomsConditionsApplied(Calendar startDateTime, int durationInMinuts, int capasity);
	public boolean checkMeetingNameAlreadyExists(String MeetingRoomName);
	public boolean checkAmenitiesPresentByMeetingRoomName(String MeetingRoomName);
	public boolean checkSeatCapacityByMeetingRoomName(String MeetingRoomName);
	public List<User> getAllUsers();
	public int insertValueInMeeting(Meeting bookedMeeting);
	public int addAttendees(List<User> attendees,int meetingId);
	public boolean checkManagerCredits(int ManagerId);
	public int deductManagerCreditByMeetingRoomName(String MeetingRoomName,int ManagerId);
}
