import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MeetingBookingDbDaoImpl {

	/**
	 * Database credentials 
	 */
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";	
	private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/projectdatabase";


	private Connection con;
	
	public MeetingBookingDbDaoImpl(){
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


	public List<Attendee> getAllUsers(){
		List<Attendee> attendees = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try {
			stmt = con.prepareStatement("SELECT Name FROM users");
			resultSet = stmt.executeQuery();
			attendees = new ArrayList<Attendee>();
			while(resultSet.next()) {
				attendees.add(new Attendee(resultSet.getInt(1), resultSet.getString(2)));
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

	public List<MeetingRoom> showMeetingRoomsConditionsApplied() {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		List<MeetingRoom> roomList = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM meetingroom");
			resultSet = stmt.executeQuery();
			roomList = new ArrayList<MeetingRoom>();
			while (resultSet.next()) {
				MeetingRoom meet = new MeetingRoom(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), new ArrayList<String>(), resultSet.getInt(4), resultSet.getFloat(5), resultSet.getInt(6));
				roomList.add(meet);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} 
		finally {
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return roomList;
	}

	public boolean checkMeetingSlotIsFreeByMeetingRoomId() {
		return true;
	}	
	public boolean checkAmenitiesPresentByMeetingRoomId() {
		return true;
	}
	public boolean checkSeatCapacityByMeetingRoomId(){
		return true;
	}
	public boolean checkManagerCradits() {
		return true;
	}
	public int insertValueInMeeting(Meeting bookedMeeting){
		int numberOfRowsUpdated = 0;
		return numberOfRowsUpdated;	
	}
	public int addAttendees(List<Attendee> attendees) {
		int numberOfRowsUpdated = 0;
		for(Attendee attendee:attendees) {
			numberOfRowsUpdated+=addAttendeeByUserIdAndMeetingId(attendee);
		}
		return numberOfRowsUpdated;
	}
	public int addAttendeeByUserIdAndMeetingId(Attendee attendee) {
		int numberOfRowsUpdated = 0;
		return numberOfRowsUpdated;
	}
	
	public int deductManagerCraditByMeetingRoomId(MeetingRoom meetingRoom) {
		int numberOfRowsUpdated = 0;
		return numberOfRowsUpdated;
	}
}
