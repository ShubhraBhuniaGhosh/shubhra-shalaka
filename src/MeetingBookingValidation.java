import java.util.Calendar;


public class MeetingBookingValidation {
	public boolean validateMeetingInformation(String meetingTitle,Calendar startDateTime, int durationInMinuts,String meetingType) throws MeetingTitleInvalidException{
		if(validateMeetingTitle(meetingTitle) && validateMeetingStartDateTime(startDateTime) && validateMeetingDurationInMinuts(durationInMinuts) && validateMeetingMeetingType(meetingType)){
			return true;
		}
		return false;
	}

	private boolean validateMeetingMeetingType(String meetingType) {
		
		return false;
	}

	private boolean validateMeetingDurationInMinuts(int durationInMinuts) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean validateMeetingStartDateTime(Calendar startDateTime) {
		Calendar today = Calendar.getInstance();
		System.out.println(today.compareTo(startDateTime));
		//if(startDateTime>)
		return false;
	}
	private boolean validateMeetingTitle(String meetingTitle) throws MeetingTitleInvalidException {
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
		return false;
	}
	public static void main(String[] args) {
		Calendar someday =  Calendar.getInstance();
		someday.set(2021, 9, 1, 12, 55);
		//someday.set(2021, 1, 26, 23, 55);
		new MeetingBookingValidation().validateMeetingStartDateTime(someday);
	}
}
