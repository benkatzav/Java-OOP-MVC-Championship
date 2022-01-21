package controller;

import listeners.ChampModelListener;
import listeners.ChampViewListener;
import model.ChampModel;
import view.ChampView;

public class ChampController implements ChampViewListener, ChampModelListener {
	
	private ChampModel theModel;
	private ChampView theView;

	public ChampController(ChampModel model, ChampView view) {
		
		theModel = model;
		theView = view;
		
		theModel.registerListener(this);
		theView.registerListener(this);
		
	}
	
	
	// ----- View Methods ----- //
	
	
	@Override
	public void setCompetitionFromUIToModel(String comp) {
		theModel.setCompetition(comp);
	}
	
	@Override
	public void addPlayerFromUIToModel(String name) {
		theModel.addPlayer(name);
	}
	
	@Override
	public void addTeamFromUIToModel(String name) {
		theModel.addTeam(name);
	}
	
	@Override
	public String playAGameFromUIToModel(String name1, String name2, int[] scoreP1, int[] scoreP2) {

		try {
			theModel.runAGame(name1, name2, scoreP1, scoreP2);
			return getWinnerFromModelToUI(name1, name2);
		} catch (Exception e) {
			theView.displayErrorMessage(e);
			return "";
		}
		
	}
	
	
	// ----- Model Methods ----- //
	
	
	@Override
	public String getWinnerFromModelToUI(String name1, String name2) {
		return theModel.getTheWinner(name1, name2);
	}
	
	
}
