package com.hsbc.meets.dao;

import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;
/**
 * This interface declare all the methods to be implemented in meeting Dao classes.
 * @author ShubhraBhuniaGhosh
 *
 */
public interface MeetingDao {

	/**
	 * This method gives a list of all suitable meeting room.
	 * @author ShubhraBhuniaGhosh
	 * @param startDateTime
	 * @param durationInMinuts
	 * @param capasity
	 * @return a list of all suitable meeting room.
	 */
	public List<MeetingRoom> getMeetingRoomsConditionsApplied(Calendar startDateTime, int durationInMinuts, int capasity);
	/**
	 * This method checks if meeting title entered Already Exists.
	 * @author ShubhraBhuniaGhosh
	 * @param MeetingRoomName
	 * @return true if it already exists else returns false
	 */
	public boolean checkMeetingNameAlreadyExists(String MeetingRoomName);
	/**
	 * This method checks Amenities Present By Meeting Room Name.
	 * @author ShubhraBhuniaGhosh
	 * @param MeetingRoomName
	 * @return true if amenity present else false
	 */
	public boolean checkAmenitiesPresentByMeetingRoomName(String MeetingRoomName);
	/**
	 * This method checks Seat Capacity By Meeting RoomName.
	 * @author ShubhraBhuniaGhosh
	 * @param MeetingRoomName
	 * @return true if Seat Capacity is grater than or equal to no of attendees
	 */
	public boolean checkSeatCapacityByMeetingRoomName(String MeetingRoomName);
	/**
	 * This method if meeting room is free at given slot.
	 * @author ShubhraBhuniaGhosh
	 * @return returns true if meeting room is free at given slot else returns false
	 */
	public boolean checkMeetingSlotIsFreeByMeetingRoomId();
	/**
	 * This method gets list of all Users.
	 * @author ShubhraBhuniaGhosh
	 * @return list of all users
	 */
	public List<User> getAllUsers();
	/**
	 * This method inserts Value of Meeting in database.
	 * @author ShubhraBhuniaGhosh
	 * @param bookedMeeting
	 * @return no of rows updated
	 */
	public int insertValueOfMeeting(Meeting bookedMeeting);
	/**
	 * This method adds attendees in database.
	 * @author ShubhraBhuniaGhosh
	 * @param attendees
	 * @param meetingId
	 * @return no of rows updated
	 */
	public int addAttendees(List<User> attendees,int meetingId);
	/**
	 * This method checks if the Manager has enough Credits.
	 * @author ShubhraBhuniaGhosh
	 * @param managerId
	 * @return true if has yes else false
	 */
	public boolean checkManagerCredits(int managerId);
	/**
	 * This method deducts Manager Credit By Meeting RoomName.
	 * @author ShubhraBhuniaGhosh
	 * @param meetingRoomName
	 * @param managerId
	 * @return no of rows updated
	 */
	public int deductManagerCreditByMeetingRoomName(String meetingRoomName,int managerId);
}
