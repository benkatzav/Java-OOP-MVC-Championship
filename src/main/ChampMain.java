package main;

import controller.ChampController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.ChampModel;
import view.ChampView;

public class ChampMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ChampModel model = new ChampModel();
		ChampView view = new ChampView(primaryStage);
		ChampController controller = new ChampController(model, view);
		
	}

}
