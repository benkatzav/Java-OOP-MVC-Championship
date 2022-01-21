package model;

import java.util.ArrayList;

import exceptions.CannotBeDrawException;
import exceptions.ScoreIsNotValidException;
import exceptions.TennisScoreIsNotValidException;

public interface Competition {

	void addParticipants(ArrayList<Participant> part);
	void addScoresToPlayers(String name1, String name2, int[] p1, int[] p2) throws ScoreIsNotValidException,
							CannotBeDrawException, TennisScoreIsNotValidException;
	void executeGame(String p1, String p2) throws TennisScoreIsNotValidException, CannotBeDrawException;
	String getWinner(String name1, String name2);
	
}
