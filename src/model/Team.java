package model;

import exceptions.ScoreIsNotValidException;

public class Team implements Participant, Comparable<Team> {
	
	protected String name;
	protected int score;
	protected boolean winner;
	
	public Team(String name) {
		
		this.name = name;
		score = 0;
		
	}

	
	// ----- Game Methods ----- //
	
	
	@Override
	public void addScores(int[] scores) throws ScoreIsNotValidException {
		
		if (scores.length > 1 && scores.length < 5) {

			if (score == 0) {	// In case this is the first game for the team
				for (int i = 0; i < scores.length; i++) {
					if (scores[i] < 0)
						throw new ScoreIsNotValidException();
					else
						score += scores[i];
				}
			}
			else {	// In case this is another game for the team
				score = 0;
				for (int i = 0; i < scores.length; i++) {
					if (scores[i] < 0)
						throw new ScoreIsNotValidException();
					else
						score += scores[i];
				}
			}
		}
		else
			throw new ScoreIsNotValidException();

	}

	
	// ----- General Methods ----- //
	
	
	@Override
	public int compareTo(Team t2) {
		
		if (this.score > t2.score)
			return 1;
		else if (this.score < t2.score)
			return 0;
		else
			return -1;
		
	}
	
	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Team))
			return false;

		Team t = (Team) other;
		return t.name.equals(this.name) && t.score == this.score;
		
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", score=" + score + ", winner=" + winner + "]";
	}
	
	
}
