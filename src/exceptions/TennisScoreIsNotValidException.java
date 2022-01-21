package exceptions;

public class TennisScoreIsNotValidException extends Exception {

	public TennisScoreIsNotValidException() {
		super("Score is not valid, please enter a valid score. (there's no player with 3 wins)");
	}
	
}
