package model;

import exceptions.ScoreIsNotValidException;

public interface Participant {
	
	void addScores(int[] scores) throws ScoreIsNotValidException;
	
}
