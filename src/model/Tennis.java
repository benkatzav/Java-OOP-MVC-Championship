package model;

import java.util.ArrayList;

import exceptions.ScoreIsNotValidException;
import exceptions.TennisScoreIsNotValidException;

public class Tennis implements Competition {
	
	protected ArrayList<Player> players;
	protected int[] p1Wins = new int[1];
	protected int[] p2Wins = new int[1];
	
	public Tennis() {
		
		players = new ArrayList<Player>();
		
	}

	@Override
	public void addParticipants(ArrayList<Participant> part) {

		for (int i = 0; i < part.size(); i++)
			players.add((Player) part.get(i));
		players.trimToSize();
		
	}

	
	// ----- Competition Methods ----- //
	
	
	public void addScoresToPlayers(String name1, String name2, int[] p1, int[] p2) throws ScoreIsNotValidException,
									TennisScoreIsNotValidException {
		
		if (checkIfValid(p1, p2)) {
			
			countNumOfWins(p1, p2);
			
			int i = getIndexByName(name1);
			players.get(i).addScores(p1Wins);
			
			i = getIndexByName(name2);
			players.get(i).addScores(p2Wins);
			
		}

	}
	
	@Override
	public void executeGame(String player1, String player2) throws TennisScoreIsNotValidException {

		Player p1 = getPlayerByName(player1);
		Player p2 = getPlayerByName(player2);
		
		if (p1.compareTo(p2) == 1) {
			p1.winner = true;
			p2.winner = false;
		}
		else if (p1.compareTo(p2) == 0) {
			p1.winner = false;
			p2.winner = true;
		}
		else
			throw new TennisScoreIsNotValidException();
		
	}

	@Override
	public String getWinner(String name1, String name2) {

		if (getPlayerByName(name1).winner)
			return name1;
		else
			return name2;
		
	}
	
	private boolean checkIfValid(int[] p1, int[] p2) throws ScoreIsNotValidException {

		// Checking valid scores
		
		for (int i = 0; i < p1.length; i++) {
			
			if ((p1[i] < 0 || p1[i] > 7) || (p2[i] < 0 || p2[i] > 7))	// Score is bigger than 7 or beneath 0
				throw new ScoreIsNotValidException();
			if ((p1[i] < 6 && p2[i] < 6) && (p1[i] > 0 || p2[i] > 0))	// If none of the players have achieved 6 wins in a game
				throw new ScoreIsNotValidException();
			if ((p1[i] == p2[i]) && p1[i] > 0)	// If both scores in single match are equal
				throw new ScoreIsNotValidException();
			if ((p1[i] == 7 && p2[i] < 5) || (p2[i] == 7 && p1[i] < 5)) // In case it's a tie-breaker situation
				throw new ScoreIsNotValidException();
			if ((p1[i] == 6 && (p2[i] > 4 && p2[i] < 7)) || (p2[i] == 6 && (p1[i] > 4 && p1[i] < 7))) // In case score is 6-5 or 6-6
				throw new ScoreIsNotValidException();
			
		}
		
		return true;

	}
	
	private void countNumOfWins(int[] p1, int[] p2) throws ScoreIsNotValidException {
		
		int p1TempWins = 0;
		int p2TempWins = 0;		
		
		for (int i = 0; i < p1.length; i++) {
			
			if (p1[i] > p2[i])
				p1TempWins++;
			else if (p1[i] < p2[i])
				p2TempWins++;
			
			if (p1TempWins > 3 || p2TempWins > 3)	// In case a game was been still played after one of the players reached 3 wins
				throw new ScoreIsNotValidException();
			
		}
		
		p1Wins[0] = p1TempWins;
		p2Wins[0] = p2TempWins;
		
	}
	
	
	// ----- General Methods ----- //
	
	
	private int getIndexByName(String n) {

		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).name.equals(n))
				return i;
		}
		return -1;
		
	}
	
	private Player getPlayerByName(String team) {
		
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).name.equals(team))
				return players.get(i);
		}
		return null;
		
	}
	
	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Tennis))
			return false;

		Tennis t = (Tennis) other;
		return t.players.equals(this.players);
		
	}

	@Override
	public String toString() {
		return "Tennis [players=" + players + "]";
	}
	
	
}
