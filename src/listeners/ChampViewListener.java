package listeners;

public interface ChampViewListener {

	void setCompetitionFromUIToModel(String comp);
	void addPlayerFromUIToModel(String name);
	void addTeamFromUIToModel(String name);
	String playAGameFromUIToModel(String name1, String name2, int[] p1, int[] p2);
	
}
