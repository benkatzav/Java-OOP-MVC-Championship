package model;

import java.util.ArrayList;

import exceptions.CannotBeDrawException;
import exceptions.ScoreIsNotValidException;

public class Football implements Competition {

	protected ArrayList<Team> teams;

	public Football() {

		teams = new ArrayList<Team>();

	}
	
	@Override
	public void addParticipants(ArrayList<Participant> part) {

		for (int i = 0; i < part.size(); i++)
			teams.add((Team) part.get(i));
		teams.trimToSize();
		
	}


	// ----- Competition Methods ----- //

	
	public void addScoresToPlayers(String name1, String name2, int[] p1, int[] p2) throws ScoreIsNotValidException,
									CannotBeDrawException {
		
		if (checkIfDraw(p1, p2))
			throw new CannotBeDrawException();
		
		else {
			
			int i = getIndexByName(name1);
			teams.get(i).addScores(p1);

			i = getIndexByName(name2);
			teams.get(i).addScores(p2);
			
		}

	}

	@Override
	public void executeGame(String team1, String team2) throws CannotBeDrawException {

		Team t1 = getTeamByName(team1);
		Team t2 = getTeamByName(team2);

		if (t1.compareTo(t2) == 1) {
			t1.winner = true;
			t2.winner = false;
		}
		else if (t1.compareTo(t2) == 0) {
			t1.winner = false;
			t2.winner = true;
		}
		else
			throw new CannotBeDrawException();

	}

	@Override
	public String getWinner(String name1, String name2) {

		if (getTeamByName(name1).winner)
			return name1;
		else
			return name2;
		
	}
	
	
	private boolean checkIfDraw(int[] p1, int[] p2) {

		int totalScoreP1 = p1[0] + p1[1];
		int totalScoreP2 = p2[0] + p2[1];
		
		if ((totalScoreP1 == totalScoreP2) && p1[2] == 0 && p2[2] == 0)
			return true;
		else
			return false;

	}
	

	// ----- General Methods ----- //


	private int getIndexByName(String n) {

		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).name.equals(n))
				return i;
		}
		return -1;
		
	}
	
	private Team getTeamByName(String team) {
		
		for (int i = 0; i < teams.size(); i++) {
			if (teams.get(i).name.equals(team))
				return teams.get(i);
		}
		return null;
		
	}
	
	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Football))
			return false;

		Football f = (Football) other;
		return f.teams.equals(this.teams);
		
	}

	@Override
	public String toString() {
		return "Football [teams=" + teams + "]";
	}
	
	
}
