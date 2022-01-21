package model;

import java.util.ArrayList;

import exceptions.CannotBeDrawException;
import exceptions.ScoreIsNotValidException;

public class Basketball implements Competition {

	protected ArrayList<Team> teams;

	public Basketball() {

		teams = new ArrayList<Team>();

	}

	@Override
	public void addParticipants(ArrayList<Participant> part) {

		for (int i = 0; i < part.size(); i++)
			teams.add((Team) part.get(i));
		teams.trimToSize();
		
	}


	// ----- Competition Methods ----- //


	public void addScoresToPlayers(String name1, String name2, int[] p1, int[] p2) throws ScoreIsNotValidException {
		
		int i = getIndexByName(name1);
		teams.get(i).addScores(p1);
		
		i = getIndexByName(name2);
		teams.get(i).addScores(p2);

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

		if (!(other instanceof Basketball))
			return false;

		Basketball r = (Basketball) other;
		return r.teams.equals(this.teams);
		
	}

	@Override
	public String toString() {
		return "Basketball [teams=" + teams + "]";
	}
	
	
}
