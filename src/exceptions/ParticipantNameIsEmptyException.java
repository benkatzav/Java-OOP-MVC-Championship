package exceptions;

public class ParticipantNameIsEmptyException extends Exception {

	public ParticipantNameIsEmptyException() {
		super("Participant name is not valid.");
	}
	
}
