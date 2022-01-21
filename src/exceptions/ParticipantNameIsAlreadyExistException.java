package exceptions;

public class ParticipantNameIsAlreadyExistException extends Exception {

	public ParticipantNameIsAlreadyExistException() {
		super("Participant name is already exist.");
	}
	
}
