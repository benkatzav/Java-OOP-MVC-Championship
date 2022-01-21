package model;

public class Player implements Participant, Comparable<Player> {

	protected String name;
	protected int score;
	protected boolean winner;
	
	public Player(String name) {
		
		this.name = name;
		score = 0;
		
	}

	
	// ----- Game Methods ----- //

	
	public void addScores(int[] scores) {
		score = scores[0];
	}
	
	
	// ----- General Methods ----- //

	
	@Override
	public int compareTo(Player p2) {

		if (this.score > p2.score)
			return 1;
		else if (this.score < p2.score)
			return 0;
		else
			return -1;
		
	}

	@Override
	public boolean equals(Object other) {

		if (!(other instanceof Player))
			return false;

		Player p = (Player) other;
		return p.name.equals(this.name) && p.score == this.score;
		
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", scores=" + score + ", winner=" + winner + "]";
	}
	
	
}
