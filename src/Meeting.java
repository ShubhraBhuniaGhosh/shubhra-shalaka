import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Meeting {
	private int meetingId;
	private String meetingTitle;
	private Date meetingDate;
	private Time startTime;
	private int durationInMinuts;
	private String meetingType;
	private List<Attendee> attendees;
	private MeetingRoom meetingRoom;
	
	public Meeting(int meetingId, String meetingTitle, Date meetingDate, Time startTime, int durationInMinuts,
			String meetingType, List<Attendee> attendees, MeetingRoom meetingRoom) {
		this.meetingId = meetingId;
		this.meetingTitle = meetingTitle;
		this.meetingDate = meetingDate;
		this.startTime = startTime;
		this.durationInMinuts = durationInMinuts;
		this.meetingType = meetingType;
		this.attendees = attendees;
		this.meetingRoom = meetingRoom;
	}
	public String getMeetingTitle() {
		return meetingTitle;
	}
	public void setMeetingTitle(String meetingTitle) {
		this.meetingTitle = meetingTitle;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public int getDurationInMinuts() {
		return durationInMinuts;
	}
	public void setDurationInMinuts(int durationInMinuts) {
		this.durationInMinuts = durationInMinuts;
	}
	public String getMeetingType() {
		return meetingType;
	}
	public void setMeetingType(String meetingType) {
		this.meetingType = meetingType;
	}
	public List<Attendee> getAttendees() {
		return attendees;
	}
	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}
	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}
	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}
	public int getMeetingId() {
		return meetingId;
	}
}
