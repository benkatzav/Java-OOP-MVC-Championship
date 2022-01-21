package exceptions;

public class ScoreIsNotValidException extends Exception {
	
	public ScoreIsNotValidException() {
		 super("Score is not valid, please enter a valid score.");
	}

}
