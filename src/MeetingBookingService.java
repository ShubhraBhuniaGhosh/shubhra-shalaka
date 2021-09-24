import java.util.Calendar;
import java.util.List;

public class MeetingBookingService {
	User Manager;
public MeetingBookingService(User Manager){
	this.Manager = Manager;
}
public void getMeetingBookingInformation(String meetingTitle,Calendar startDateTime, int durationInMinuts,String meetingType) {
	validateMeetingInformation(String meetingTitle,Calendar startDateTime, int durationInMinuts,String meetingType);
	
}
public void getAttendeesList(List<User>) {
	
}
}
