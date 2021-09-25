package com.hsbc.meets.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hsbc.meets.dao.MeetingDao;
import com.hsbc.meets.entity.Meeting;
import com.hsbc.meets.entity.MeetingRoom;
import com.hsbc.meets.entity.User;

/**
 * This class implements {@link MeetingDao}
 * @author ShubhraBhuniaGhosh
 *
 */
public class MeetingDbDaoImpl implements MeetingDao{

	/**
	 * Database credentials 
	 */
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";	
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/projectdatabase";


	private Connection con;
	
	public MeetingDbDaoImpl(){
		con = null;
		try
		{
			Class.forName(DRIVER_CLASS_NAME);
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	protected void finalize()  {
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public List<User> getAllUsers(){
		List<User> attendees = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = con.prepareStatement("SELECT Name FROM users");
			resultSet = stmt.executeQuery();
			attendees = new ArrayList<User>();
			while(resultSet.next()) {
				attendees.add(new User());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{	
				if(resultSet!=null)
				{
					resultSet.close();
				}

				if(stmt != null)
				{
					stmt.close();
				}
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return attendees;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public List<MeetingRoom> getMeetingRoomsConditionsApplied(Calendar startDateTime, int durationInMinuts, int capasity) {
		ArrayList<MeetingRoom> l = new ArrayList<MeetingRoom>();
		l.add(new MeetingRoom());
		l.add(new MeetingRoom());
		l.add(new MeetingRoom());
		l.add(new MeetingRoom());
		l.add(new MeetingRoom());

		return l;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean checkMeetingSlotIsFreeByMeetingRoomId() {
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean checkMeetingNameAlreadyExists(String MeetingRoomName) {
		return false;	
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean checkAmenitiesPresentByMeetingRoomName(String MeetingRoomName) {
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean checkSeatCapacityByMeetingRoomName(String MeetingRoomName){
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public boolean checkManagerCredits(int ManagerId) {
		return true;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public int insertValueOfMeeting(Meeting bookedMeeting){
		int numberOfRowsUpdated = 0;
		return 1;	
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public int addAttendees(List<User> attendees,int meetingId) {
		int numberOfRowsUpdated = 0;
		for(User attendee:attendees) {
			numberOfRowsUpdated+=addAttendeeByUserIdAndMeetingId(attendee.getEmail(),meetingId);
		}
		return numberOfRowsUpdated;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 * @param emailId
	 * @param meetingIdGotFromInsertValueInMeeting
	 * @return
	 */
	private int addAttendeeByUserIdAndMeetingId(String emailId,int meetingIdGotFromInsertValueInMeeting) {
		int numberOfRowsUpdated = 0;
		return 1;
	}
	/**
	 * @author ShubhraBhuniaGhosh
	 */
	public int deductManagerCreditByMeetingRoomName(String MeetingRoomName,int ManagerId) {
		int numberOfRowsUpdated = 0;
		return 1;
	}

}
