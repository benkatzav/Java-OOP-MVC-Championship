package model;

import java.util.ArrayList;

import exceptions.CannotBeDrawException;
import exceptions.ScoreIsNotValidException;
import exceptions.TennisScoreIsNotValidException;
import listeners.ChampModelListener;

public class ChampModel {
	
	private ChampModelListener listener;
	private Competition comp;
	private ArrayList<Participant> part;
	
	public ChampModel() {
		
		part = new ArrayList<Participant>();
		
	}
	
	public void setCompetition(String competition) {

		if (competition.equalsIgnoreCase("Football"))
			comp = new Football();
		else if (competition.equalsIgnoreCase("Basketball"))
			comp = new Basketball();
		else
			comp = new Tennis();

	}
	
	
	// ----- Listener Methods ----- //
	
	
	public void registerListener(ChampModelListener listen) {
		listener = listen;
	}
	
	
	// ----- Manage Methods ----- //
	
	
	public void addTeam(String name) {

		part.add(new Team(name));
		part.trimToSize();

		if (part.size() == 8)
			addParticipantsIntoCompetition();
		
	}
	
	
	public void addPlayer(String name) {
		
		part.add(new Player(name));
		part.trimToSize();
		
		if (part.size() == 8)
			addParticipantsIntoCompetition();
		
	}
	
	
	public void addParticipantsIntoCompetition() {
		comp.addParticipants(part);
	}
	
	
	public void runAGame(String name1, String name2, int[] p1, int[] p2) throws ScoreIsNotValidException,
						TennisScoreIsNotValidException, CannotBeDrawException {
		
		comp.addScoresToPlayers(name1, name2, p1, p2);
		comp.executeGame(name1, name2);
		
	}
	
	public String getTheWinner(String name1, String name2) {
		return comp.getWinner(name1, name2);
	}
	
	
}
