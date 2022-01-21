package exceptions;

public class CannotBeDrawException extends Exception {

	public CannotBeDrawException() {
		super("Result can not be draw, please enter a valid score.");
	}
	
}
