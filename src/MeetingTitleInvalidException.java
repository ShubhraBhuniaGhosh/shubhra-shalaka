
public class MeetingTitleInvalidException extends Exception {
	@Override
	public String toString() {
		return "Meeting title should be at least 4 letters long and at max 20 letters long.\nIt can only contain letters.\nNumbers and special characters in the name are not allowed.";
	}
}
