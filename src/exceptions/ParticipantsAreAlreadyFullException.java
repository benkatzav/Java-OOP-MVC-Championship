package exceptions;

public class ParticipantsAreAlreadyFullException extends Exception {
	
	public ParticipantsAreAlreadyFullException() {
		super("Participants are already full, can not add more than 8.");
	}
	
}
