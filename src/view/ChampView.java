package view;

import exceptions.CompetitionHasNotBeenSelectedException;
import exceptions.ParticipantNameIsAlreadyExistException;
import exceptions.ParticipantNameIsEmptyException;
import exceptions.ParticipantsAreAlreadyFullException;
import exceptions.ScoreIsNotValidException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import listeners.ChampViewListener;

public class ChampView {
	
	private ChampViewListener listener;
	
	Label lblWinner;
	
	// Winner
	
	TextField tfWinner;

	// Finals

	TextField tfFinalPart1;
	TextField tfFinalPart2;

	// Semi-Finals

	TextField tfSemiPart1;
	TextField tfSemiPart2;
	TextField tfSemiPart3;
	TextField tfSemiPart4;

	// Quarter-Finals

	TextField tfQtrPart1;
	TextField tfQtrPart2;
	TextField tfQtrPart3;
	TextField tfQtrPart4;
	TextField tfQtrPart5;
	TextField tfQtrPart6;
	TextField tfQtrPart7;
	TextField tfQtrPart8;
	
	// Play Game Buttons

	// Quarter

	Button btnQPlay1;
	Button btnQPlay2;
	Button btnQPlay3;
	Button btnQPlay4;

	// Semi

	Button btnSPlay1;
	Button btnSPlay2;

	// Final

	Button btnFPlay;

	public ChampView(Stage theStage) {

		theStage.setTitle("Championship");

		// --- Tournament Bracket --- //

		// Winner
		
		lblWinner = new Label("Congratulations!");
		lblWinner.setFont(new Font("Tahoma", 12));
		lblWinner.setTextFill(Color.RED);
		lblWinner.setVisible(false);
		
		tfWinner = new TextField();

		// Finals

		tfFinalPart1 = new TextField();
		tfFinalPart2 = new TextField();

		// Semi-Finals

		tfSemiPart1 = new TextField();
		tfSemiPart2 = new TextField();
		tfSemiPart3 = new TextField();
		tfSemiPart4 = new TextField();

		// Quarter-Finals

		tfQtrPart1 = new TextField();
		tfQtrPart2 = new TextField();
		tfQtrPart3 = new TextField();
		tfQtrPart4 = new TextField();
		tfQtrPart5 = new TextField();
		tfQtrPart6 = new TextField();
		tfQtrPart7 = new TextField();
		tfQtrPart8 = new TextField();

		tfWinner.setEditable(false);
		tfFinalPart1.setEditable(false);
		tfFinalPart2.setEditable(false);
		tfSemiPart1.setEditable(false);
		tfSemiPart2.setEditable(false);
		tfSemiPart3.setEditable(false);
		tfSemiPart4.setEditable(false);
		tfQtrPart1.setEditable(false);
		tfQtrPart2.setEditable(false);
		tfQtrPart3.setEditable(false);
		tfQtrPart4.setEditable(false);
		tfQtrPart5.setEditable(false);
		tfQtrPart6.setEditable(false);
		tfQtrPart7.setEditable(false);
		tfQtrPart8.setEditable(false);
		
		VBox vbQuarter = new VBox(); // Quarter-Finals
		VBox vbSemi = new VBox(); // Semi-Finals
		VBox vbFinal = new VBox(); // Final
		VBox vbWinner = new VBox(); // Winner

		vbQuarter.setSpacing(30);
		vbQuarter.setMinWidth(120);
		vbQuarter.setMaxWidth(120);
		vbQuarter.getChildren().addAll(tfQtrPart1, tfQtrPart2, tfQtrPart3, tfQtrPart4, tfQtrPart5, tfQtrPart6,
				tfQtrPart7, tfQtrPart8);

		vbSemi.setSpacing(85);
		vbSemi.setMinWidth(120);
		vbSemi.setMaxWidth(120);
		vbSemi.setPadding(new Insets(28, 0, 0, 0));
		vbSemi.getChildren().addAll(tfSemiPart1, tfSemiPart2, tfSemiPart3, tfSemiPart4);
		vbSemi.setVisible(false);

		vbFinal.setSpacing(190);
		vbFinal.setMinWidth(120);
		vbFinal.setMaxWidth(120);
		vbFinal.setPadding(new Insets(84, 0, 0, 0));
		vbFinal.getChildren().addAll(tfFinalPart1, tfFinalPart2);
		vbFinal.setVisible(false);

		vbWinner.setSpacing(10);
		vbWinner.setMinWidth(120);
		vbWinner.setMaxWidth(120);
		vbWinner.setPadding(new Insets(194, 0, 0, 0));
		vbWinner.getChildren().addAll(tfWinner, lblWinner);
		vbWinner.setVisible(false);

		// Play Game Buttons

		// Quarter

		btnQPlay1 = new Button("Play a game");
		btnQPlay2 = new Button("Play a game");
		btnQPlay3 = new Button("Play a game");
		btnQPlay4 = new Button("Play a game");

		// Semi

		btnSPlay1 = new Button("Play a game");
		btnSPlay2 = new Button("Play a game");

		// Final

		btnFPlay = new Button("Play a game");

		btnSPlay1.setDisable(true);
		btnSPlay2.setDisable(true);
		btnFPlay.setDisable(true);
		
		VBox vbQPlay = new VBox();
		VBox vbSPlay = new VBox();
		VBox vbFPlay = new VBox();

		vbQPlay.setSpacing(85);
		vbQPlay.setPadding(new Insets(28, 0, 0, 0));
		vbQPlay.setMinWidth(90);
		vbQPlay.setVisible(false);
		vbQPlay.getChildren().addAll(btnQPlay1, btnQPlay2, btnQPlay3, btnQPlay4);

		vbSPlay.setSpacing(190);
		vbSPlay.setPadding(new Insets(84, 0, 0, 0));
		vbSPlay.setMinWidth(90);
		vbSPlay.setVisible(false);
		vbSPlay.getChildren().addAll(btnSPlay1, btnSPlay2);

		vbFPlay.setPadding(new Insets(194, 0, 0, 0));
		vbFPlay.setMinWidth(90);
		vbFPlay.setVisible(false);
		vbFPlay.getChildren().add(btnFPlay);

		HBox hbTour = new HBox();

		hbTour.setSpacing(40);
		hbTour.getChildren().addAll(vbQuarter, vbQPlay, vbSemi, vbSPlay, vbFinal, vbFPlay, vbWinner);

		// ----------------------------------------------------- //

		// ----- Start Menu ----- //

		// Participant name

		Label lbPartName = new Label("Participant name:");
		TextField tfPartName = new TextField();

		HBox hbPartName = new HBox();
		hbPartName.setSpacing(20);
		hbPartName.getChildren().addAll(lbPartName, tfPartName);

		// Manage Buttons

		Button btnAddPart = new Button("Add Participant");
		Button btnStartChamp = new Button("Start Championship");
		Button btnOk = new Button("OK");
		btnStartChamp.setDisable(true);
		btnOk.setDisable(true);

		HBox hbManageBtn = new HBox();
		hbManageBtn.setSpacing(40);
		hbManageBtn.getChildren().addAll(btnAddPart, btnStartChamp);

		// Choose Competition

		Label lbChGame = new Label("Choose Game:");

		RadioButton rbTennis = new RadioButton("Tennis");
		RadioButton rbBasketball = new RadioButton("Basketball");
		RadioButton rbFootball = new RadioButton("Football");
		rbTennis.setDisable(true);
		rbFootball.setDisable(true);
		rbBasketball.setDisable(true);

		ToggleGroup radioGroup = new ToggleGroup();

		rbTennis.setToggleGroup(radioGroup);
		rbBasketball.setToggleGroup(radioGroup);
		rbFootball.setToggleGroup(radioGroup);

		// Tournament, Add&Start, Choose Competition

		VBox vbTour = new VBox();
		VBox vbManage = new VBox();
		VBox vbType = new VBox();

		vbTour.setSpacing(10);
		vbTour.setPadding(new Insets(20, -450, 0, 0));
		vbManage.setSpacing(10);
		vbManage.setPadding(new Insets(150, 0, 0, -400));
		vbType.setSpacing(10);
		vbType.setPadding(new Insets(130, 0, 0, -180));

		vbTour.getChildren().add(hbTour);
		vbManage.getChildren().addAll(hbPartName, hbManageBtn);
		vbType.getChildren().addAll(lbChGame, rbTennis, rbBasketball, rbFootball, btnOk);

		// ----- Main HBox ----- //

		HBox hbRoot = new HBox();

		hbRoot.setAlignment(Pos.CENTER);
		hbRoot.setSpacing(210);

		hbRoot.getChildren().addAll(vbTour, vbManage, vbType);

		// ----------------- Actions ----------------- //

		// ----- Tournament Actions ----- //

		// TODO: Play a game

		btnQPlay1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfQtrPart1.getText(), tfQtrPart2.getText(), tfSemiPart1, btnQPlay1);
			}

		});

		btnQPlay2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfQtrPart3.getText(), tfQtrPart4.getText(), tfSemiPart2, btnQPlay2);
			}

		});

		btnQPlay3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfQtrPart5.getText(), tfQtrPart6.getText(), tfSemiPart3, btnQPlay3);
			}

		});

		btnQPlay4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfQtrPart7.getText(), tfQtrPart8.getText(), tfSemiPart4, btnQPlay4);
			}

		});

		btnSPlay1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfSemiPart1.getText(), tfSemiPart2.getText(), tfFinalPart1, btnSPlay1);
			}

		});

		btnSPlay2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfSemiPart3.getText(), tfSemiPart4.getText(), tfFinalPart2, btnSPlay2);
			}

		});

		btnFPlay.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				playAGame(rbTennis, rbBasketball, tfFinalPart1.getText(), tfFinalPart2.getText(), tfWinner, btnFPlay);
			}

		});

		// ----- Menu Actions ----- //

		// Add Participant
		btnAddPart.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (tfPartName.getText().isEmpty()) // In case the user trying to add player while name is empty
					displayErrorMessage(new ParticipantNameIsEmptyException());
				else if (tfPartName.getText().equalsIgnoreCase(tfQtrPart1.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart2.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart3.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart4.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart5.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart6.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart7.getText())
						|| tfPartName.getText().equalsIgnoreCase(tfQtrPart8.getText())) {
					displayErrorMessage(new ParticipantNameIsAlreadyExistException()); // In case the user trying to add
																						// player that is already exists
				} else {
					try {
						if (tfQtrPart1.getText().isEmpty())
							tfQtrPart1.setText(tfPartName.getText());
						else if (tfQtrPart2.getText().isEmpty())
							tfQtrPart2.setText(tfPartName.getText());
						else if (tfQtrPart3.getText().isEmpty())
							tfQtrPart3.setText(tfPartName.getText());
						else if (tfQtrPart4.getText().isEmpty())
							tfQtrPart4.setText(tfPartName.getText());
						else if (tfQtrPart5.getText().isEmpty())
							tfQtrPart5.setText(tfPartName.getText());
						else if (tfQtrPart6.getText().isEmpty())
							tfQtrPart6.setText(tfPartName.getText());
						else if (tfQtrPart7.getText().isEmpty())
							tfQtrPart7.setText(tfPartName.getText());
						else if (tfQtrPart8.getText().isEmpty()) {
							tfQtrPart8.setText(tfPartName.getText());
							rbTennis.setDisable(false);
							rbFootball.setDisable(false);
							rbBasketball.setDisable(false);
							btnOk.setDisable(false);
						} else {
							throw new ParticipantsAreAlreadyFullException(); // Over than 8 players
						}
					} catch (Exception e) {
						displayErrorMessage(e);
					}
				}
			}
		});

		// Start Championship

		btnStartChamp.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				// In view
				vbManage.setVisible(false);
				vbType.setVisible(false);

				vbSemi.setVisible(true);
				vbFinal.setVisible(true);
				vbWinner.setVisible(true);
				vbQPlay.setVisible(true);
				vbSPlay.setVisible(true);
				vbFPlay.setVisible(true);

				// In model
				if (rbTennis.isSelected()) {

					listener.setCompetitionFromUIToModel("Tennis");

					listener.addPlayerFromUIToModel(tfQtrPart1.getText());
					listener.addPlayerFromUIToModel(tfQtrPart2.getText());
					listener.addPlayerFromUIToModel(tfQtrPart3.getText());
					listener.addPlayerFromUIToModel(tfQtrPart4.getText());
					listener.addPlayerFromUIToModel(tfQtrPart5.getText());
					listener.addPlayerFromUIToModel(tfQtrPart6.getText());
					listener.addPlayerFromUIToModel(tfQtrPart7.getText());
					listener.addPlayerFromUIToModel(tfQtrPart8.getText());

				} else if (rbBasketball.isSelected()) {

					listener.setCompetitionFromUIToModel("Basketball");

					listener.addTeamFromUIToModel(tfQtrPart1.getText());
					listener.addTeamFromUIToModel(tfQtrPart2.getText());
					listener.addTeamFromUIToModel(tfQtrPart3.getText());
					listener.addTeamFromUIToModel(tfQtrPart4.getText());
					listener.addTeamFromUIToModel(tfQtrPart5.getText());
					listener.addTeamFromUIToModel(tfQtrPart6.getText());
					listener.addTeamFromUIToModel(tfQtrPart7.getText());
					listener.addTeamFromUIToModel(tfQtrPart8.getText());

				} else {

					listener.setCompetitionFromUIToModel("Football");

					listener.addTeamFromUIToModel(tfQtrPart1.getText());
					listener.addTeamFromUIToModel(tfQtrPart2.getText());
					listener.addTeamFromUIToModel(tfQtrPart3.getText());
					listener.addTeamFromUIToModel(tfQtrPart4.getText());
					listener.addTeamFromUIToModel(tfQtrPart5.getText());
					listener.addTeamFromUIToModel(tfQtrPart6.getText());
					listener.addTeamFromUIToModel(tfQtrPart7.getText());
					listener.addTeamFromUIToModel(tfQtrPart8.getText());

				}

			}
		});

		// OK Button

		btnOk.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					if (rbTennis.isSelected()) {
						rbBasketball.setDisable(true);
						rbFootball.setDisable(true);
						btnOk.setDisable(true);
						btnStartChamp.setDisable(false);
					} else if (rbBasketball.isSelected()) {
						rbTennis.setDisable(true);
						rbFootball.setDisable(true);
						btnOk.setDisable(true);
						btnStartChamp.setDisable(false);
					} else if (rbFootball.isSelected()) {
						rbTennis.setDisable(true);
						rbBasketball.setDisable(true);
						btnOk.setDisable(true);
						btnStartChamp.setDisable(false);
					} else
						throw new CompetitionHasNotBeenSelectedException(); // No radio button is selected
				} catch (Exception e) {
					displayErrorMessage(e);
				}

			}
		});

		// ----------------------------------------------------- //

		// ----- Main VBox ----- //

		Label lbChamp = new Label("Championship");
		lbChamp.setAlignment(Pos.TOP_CENTER);
		lbChamp.setPadding(new Insets(-100, 0, 0, 0));
		lbChamp.setFont(new Font("Tahoma", 26));
		lbChamp.setTextFill(Color.YELLOWGREEN);

		VBox vbRoot = new VBox();

		vbRoot.setAlignment(Pos.CENTER);
		vbRoot.getChildren().addAll(lbChamp, hbRoot);

		// ----- Scene ----- //

		Scene scene = new Scene(vbRoot, 1100, 650);

		theStage.setScene(scene);
		theStage.show();

	}

	
	// -----------------------------------------------------------------------------------------------------

	
	// ----- Listener Methods ----- //

	
	public void registerListener(ChampViewListener listen) {
		listener = listen;
	}

	
	// ----- General Methods ----- //

	
	public void displayErrorMessage(Exception e) {

		Stage errorMessage = new Stage();
		errorMessage.setTitle("Error");

		Label lblError = new Label(e.getMessage());

		Button btnClose = new Button("Close");
		
		VBox vbError = new VBox();
		vbError.setAlignment(Pos.CENTER);
		vbError.setSpacing(15);
		vbError.setPadding(new Insets(10, 0, 0, 0));
		vbError.getChildren().addAll(lblError, btnClose);

		Scene errorScene = new Scene(vbError, 300, 90);

		errorMessage.setScene(errorScene);
		errorMessage.show();

		btnClose.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				errorMessage.close();
			}
			
		});
		
	}

	
	// ----- Actions Methods ----- //

	
	private void playAGame(RadioButton rbTennis, RadioButton rbBasketball, String p1, String p2,
			TextField nextStage, Button prevBtn) {

		Button btnDone = new Button("Done");
		Stage gameStage = new Stage();
		gameStage.setTitle("Game");

		if (rbTennis.isSelected()) {	// Tennis
			
			TennisBox tennis = new TennisBox(p1, p2, btnDone);
			
			gameStage.setScene(new Scene(tennis.vbGame, 300, 200));
			gameStage.show();
			
			// Done Action
			
			btnDone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					try {
						
						if (!tennis.tfSet1P1.getText().isEmpty() &&
							!tennis.tfSet1P2.getText().isEmpty() &&
							!tennis.tfSet2P1.getText().isEmpty() &&
							!tennis.tfSet2P2.getText().isEmpty() &&
							!tennis.tfSet3P1.getText().isEmpty() &&
							!tennis.tfSet3P2.getText().isEmpty() ) {	// For cases when not both player's scores has inserted
							
							if ((!tennis.tfSet4P1.getText().isEmpty() && !tennis.tfSet4P2.getText().isEmpty()) ||
								 (tennis.tfSet4P1.getText().isEmpty() && tennis.tfSet4P2.getText().isEmpty()) ) {	
								// For cases when not both player's scores has inserted
								
								if ((!tennis.tfSet5P1.getText().isEmpty() && !tennis.tfSet5P2.getText().isEmpty()) ||
								     (tennis.tfSet5P1.getText().isEmpty() && tennis.tfSet5P2.getText().isEmpty()) ) {
									// For cases when not both player's scores has inserted

									String winner = listener.playAGameFromUIToModel(p1, p2,tennis.getPlayerScores(p1),
											tennis.getPlayerScores(p2));

									if (!winner.isEmpty()) {
										
										nextStage.setText(winner);
										prevBtn.setDisable(true);
										
										if (!tfSemiPart1.getText().isEmpty() && !tfSemiPart2.getText().isEmpty()) {
											if (tfFinalPart1.getText().isEmpty())
												btnSPlay1.setDisable(false);
										}
										
										if (!tfSemiPart3.getText().isEmpty() && !tfSemiPart4.getText().isEmpty()) {
											if (tfFinalPart2.getText().isEmpty())
												btnSPlay2.setDisable(false);
										}
										
										if (!tfFinalPart1.getText().isEmpty() && !tfFinalPart2.getText().isEmpty()) {
											if (tfWinner.getText().isEmpty())
												btnFPlay.setDisable(false);
										}
										
										if (!tfWinner.getText().isEmpty()) {
											btnFPlay.setDisable(true);
											lblWinner.setVisible(true);
										}
										
									}

								}
								else
									throw new ScoreIsNotValidException();
							}
							else
								throw new ScoreIsNotValidException();
						}
						else
							throw new ScoreIsNotValidException();
						
					} catch (Exception e) {
						displayErrorMessage(e);
					}
					
					gameStage.close();
					
				}

			});

		} else if (rbBasketball.isSelected()) {	// Basketball

			BasketballBox basketball = new BasketballBox(p1, p2, btnDone);
			
			gameStage.setScene(new Scene(basketball.vbGame, 300, 200));
			gameStage.show();
			
			// Done Action
			
			btnDone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					try {
						
						if (!basketball.tfQtr1P1.getText().isEmpty() &&
							!basketball.tfQtr1P2.getText().isEmpty() &&
							!basketball.tfQtr2P1.getText().isEmpty() &&
							!basketball.tfQtr2P2.getText().isEmpty() &&
							!basketball.tfQtr3P1.getText().isEmpty() &&
							!basketball.tfQtr3P2.getText().isEmpty() &&
							!basketball.tfQtr1P1.getText().isEmpty() &&
							!basketball.tfQtr1P2.getText().isEmpty() ) {	// For cases when not both player's scores has inserted
							
							String winner = listener.playAGameFromUIToModel(p1, p2,basketball.getPlayerScores(p1),
									basketball.getPlayerScores(p2));
							
							if (!winner.isEmpty()) {
								
								nextStage.setText(winner);
								prevBtn.setDisable(true);
								
								if (!tfSemiPart1.getText().isEmpty() && !tfSemiPart2.getText().isEmpty()) {
									if (tfFinalPart1.getText().isEmpty())
										btnSPlay1.setDisable(false);
								}
								
								if (!tfSemiPart3.getText().isEmpty() && !tfSemiPart4.getText().isEmpty()) {
									if (tfFinalPart2.getText().isEmpty())
										btnSPlay2.setDisable(false);
								}
								
								if (!tfFinalPart1.getText().isEmpty() && !tfFinalPart2.getText().isEmpty()) {
									if (tfWinner.getText().isEmpty())
										btnFPlay.setDisable(false);
								}
								
								if (!tfWinner.getText().isEmpty()) {
									btnFPlay.setDisable(true);
									lblWinner.setVisible(true);
								}
								
							}
							
						}
						else
							throw new ScoreIsNotValidException();
						
					} catch (Exception e) {
						displayErrorMessage(e);
					}
					
					gameStage.close();
					
				}

			});

		}
		
		else {	// Football

			FootballBox football = new FootballBox(p1, p2, btnDone);
			
			gameStage.setScene(new Scene(football.vbGame, 300, 200));
			gameStage.show();

			// Done Action
			
			btnDone.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					
					try {
						
						if (!football.tfFirstHalf1.getText().isEmpty() &&
							!football.tfFirstHalf2.getText().isEmpty() &&
							!football.tfSecHalf1.getText().isEmpty() &&
							!football.tfSecHalf2.getText().isEmpty() ) {	// For cases when not both player's scores has inserted
							
							if ((!football.tfPen1.getText().isEmpty() && !football.tfPen2.getText().isEmpty()) ||
								 (football.tfPen1.getText().isEmpty() && football.tfPen2.getText().isEmpty()) ) {	
								// For cases when not both player's scores has inserted

								String winner = listener.playAGameFromUIToModel(p1, p2,football.getPlayerScores(p1),
										football.getPlayerScores(p2));

								if (!winner.isEmpty()) {
									
									nextStage.setText(winner);
									prevBtn.setDisable(true);
									
									if (!tfSemiPart1.getText().isEmpty() && !tfSemiPart2.getText().isEmpty()) {
										if (tfFinalPart1.getText().isEmpty())
											btnSPlay1.setDisable(false);
									}
									
									if (!tfSemiPart3.getText().isEmpty() && !tfSemiPart4.getText().isEmpty()) {
										if (tfFinalPart2.getText().isEmpty())
											btnSPlay2.setDisable(false);
									}
									
									if (!tfFinalPart1.getText().isEmpty() && !tfFinalPart2.getText().isEmpty()) {
										if (tfWinner.getText().isEmpty())
											btnFPlay.setDisable(false);
									}
									
									if (!tfWinner.getText().isEmpty()) {
										btnFPlay.setDisable(true);
										lblWinner.setVisible(true);
									}
									
								}

							}
							else
								throw new ScoreIsNotValidException();
						}
						else
							throw new ScoreIsNotValidException();
						
					} catch (Exception e) {
						displayErrorMessage(e);
					}
					
					gameStage.close();
					
				}

			});
			
		}

	}

	
	// ----- Game Boxes ----- //

	
	class FootballBox extends VBox {

		public VBox vbGame;

		Label lblP1;
		Label lblP2;

		TextField tfFirstHalf1;
		TextField tfFirstHalf2;
		TextField tfSecHalf1;
		TextField tfSecHalf2;
		TextField tfPen1;
		TextField tfPen2;
		
		public FootballBox(String p1, String p2, Button btnDone) {

			Label lblComp = new Label("Football Game");
			lblComp.setFont(new Font("Tahoma", 18));
			lblComp.setTextFill(Color.FORESTGREEN);

			lblP1 = new Label(p1);
			lblP2 = new Label(p2);

			tfFirstHalf1 = new TextField();
			tfFirstHalf2 = new TextField();
			tfSecHalf1 = new TextField();
			tfSecHalf2 = new TextField();
			tfPen1 = new TextField();
			tfPen2 = new TextField();

			tfFirstHalf1.setMaxWidth(30);
			tfFirstHalf2.setMaxWidth(30);
			tfSecHalf1.setMaxWidth(30);
			tfSecHalf2.setMaxWidth(30);
			tfPen1.setMaxWidth(30);
			tfPen2.setMaxWidth(30);

			btnDone.setMaxWidth(60);

			VBox vbNames = new VBox();
			VBox vbFHalf = new VBox();
			VBox vbSHalf = new VBox();
			VBox vbPenalties = new VBox();

			vbNames.setSpacing(25);
			vbFHalf.setSpacing(20);
			vbSHalf.setSpacing(20);
			vbPenalties.setSpacing(20);

			vbNames.setPadding(new Insets(5, 0, 0, 0));

			vbNames.getChildren().addAll(lblP1, lblP2);
			vbFHalf.getChildren().addAll(tfFirstHalf1, tfFirstHalf2);
			vbSHalf.getChildren().addAll(tfSecHalf1, tfSecHalf2);
			vbPenalties.getChildren().addAll(tfPen1, tfPen2);

			HBox hbGame = new HBox();
			hbGame.setSpacing(10);
			hbGame.setAlignment(Pos.CENTER);
			hbGame.getChildren().addAll(vbNames, vbFHalf, vbSHalf, vbPenalties, btnDone);

			vbGame = new VBox();
			vbGame.setAlignment(Pos.CENTER);
			vbGame.setSpacing(25);
			vbGame.getChildren().addAll(lblComp, hbGame, btnDone);

		}
		
		// Methods
		
		public int[] getPlayerScores(String player) {
			
			if (player.equals(lblP1.getText())) {	// Player 1
				int[] scores = {
						Integer.parseInt(tfFirstHalf1.getText()),
						Integer.parseInt(tfSecHalf1.getText()),
						tfPen1.getText().equals("") ? 0 : Integer.parseInt(tfPen1.getText())	// If empty than 0, else the result
				};
				return scores;
			}
			else {	// Player 2
				int[] scores = {
						Integer.parseInt(tfFirstHalf2.getText()),
						Integer.parseInt(tfSecHalf2.getText()),
						tfPen2.getText().equals("") ? 0 : Integer.parseInt(tfPen2.getText())	// If empty than 0, else the result
				};
				return scores;
			}
			
		}

	}

	class BasketballBox extends VBox {

		public VBox vbGame;
		
		Label lblP1;
		Label lblP2;

		TextField tfQtr1P1;
		TextField tfQtr1P2;
		TextField tfQtr2P1;
		TextField tfQtr2P2;
		TextField tfQtr3P1;
		TextField tfQtr3P2;
		TextField tfQtr4P1;
		TextField tfQtr4P2;
		
		public BasketballBox(String p1, String p2, Button btnDone) {

			Label lblComp = new Label("Basketball Game");
			lblComp.setFont(new Font("Tahoma", 18));
			lblComp.setTextFill(Color.ORANGE);

			lblP1 = new Label(p1);
			lblP2 = new Label(p2);

			tfQtr1P1 = new TextField();
			tfQtr1P2 = new TextField();
			tfQtr2P1 = new TextField();
			tfQtr2P2 = new TextField();
			tfQtr3P1 = new TextField();
			tfQtr3P2 = new TextField();
			tfQtr4P1 = new TextField();
			tfQtr4P2 = new TextField();

			tfQtr1P1.setMaxWidth(30);
			tfQtr1P2.setMaxWidth(30);
			tfQtr2P1.setMaxWidth(30);
			tfQtr2P2.setMaxWidth(30);
			tfQtr3P1.setMaxWidth(30);
			tfQtr3P2.setMaxWidth(30);
			tfQtr4P1.setMaxWidth(30);
			tfQtr4P2.setMaxWidth(30);

			btnDone.setMaxWidth(60);

			VBox vbNames = new VBox();
			VBox vbQ1 = new VBox();
			VBox vbQ2 = new VBox();
			VBox vbQ3 = new VBox();
			VBox vbQ4 = new VBox();

			vbNames.setSpacing(25);
			vbQ1.setSpacing(20);
			vbQ2.setSpacing(20);
			vbQ3.setSpacing(20);
			vbQ4.setSpacing(20);

			vbNames.setPadding(new Insets(5, 0, 0, 0));

			vbNames.getChildren().addAll(lblP1, lblP2);
			vbQ1.getChildren().addAll(tfQtr1P1, tfQtr1P2);
			vbQ2.getChildren().addAll(tfQtr2P1, tfQtr2P2);
			vbQ3.getChildren().addAll(tfQtr3P1, tfQtr3P2);
			vbQ4.getChildren().addAll(tfQtr4P1, tfQtr4P2);

			HBox hbGame = new HBox();
			hbGame.setSpacing(10);
			hbGame.setAlignment(Pos.CENTER);
			hbGame.getChildren().addAll(vbNames, vbQ1, vbQ2, vbQ3, vbQ4, btnDone);

			vbGame = new VBox();
			vbGame.setAlignment(Pos.CENTER);
			vbGame.setSpacing(25);
			vbGame.getChildren().addAll(lblComp, hbGame, btnDone);
		}

		// Methods
		
		public int[] getPlayerScores(String player) {
			
			if (player.equals(lblP1.getText())) {	// Player 1
				int[] scores = {
						Integer.parseInt(tfQtr1P1.getText()),
						Integer.parseInt(tfQtr2P1.getText()),
						Integer.parseInt(tfQtr3P1.getText()),
						Integer.parseInt(tfQtr4P1.getText()),
				};
				return scores;
			}
			else {	// Player 2
				int[] scores = {
						Integer.parseInt(tfQtr1P2.getText()),
						Integer.parseInt(tfQtr2P2.getText()),
						Integer.parseInt(tfQtr3P2.getText()),
						Integer.parseInt(tfQtr4P2.getText()),
				};
				return scores;
			}
			
		}
		
	}

	class TennisBox extends VBox {

		public VBox vbGame;
		
		Label lblP1;
		Label lblP2;
		
		TextField tfSet1P1;
		TextField tfSet1P2;
		TextField tfSet2P1;
		TextField tfSet2P2;
		TextField tfSet3P1;
		TextField tfSet3P2;
		TextField tfSet4P1;
		TextField tfSet4P2;
		TextField tfSet5P1;
		TextField tfSet5P2;

		public TennisBox(String p1, String p2, Button btnDone) {

			Label lblComp = new Label("Tennis Game");
			lblComp.setFont(new Font("Tahoma", 18));
			lblComp.setTextFill(Color.YELLOWGREEN);

			lblP1 = new Label(p1);
			lblP2 = new Label(p2);

			tfSet1P1 = new TextField();
			tfSet1P2 = new TextField();
			tfSet2P1 = new TextField();
			tfSet2P2 = new TextField();
			tfSet3P1 = new TextField();
			tfSet3P2 = new TextField();
			tfSet4P1 = new TextField();
			tfSet4P2 = new TextField();
			tfSet5P1 = new TextField();
			tfSet5P2 = new TextField();

			tfSet1P1.setMaxWidth(30);
			tfSet1P2.setMaxWidth(30);
			tfSet2P1.setMaxWidth(30);
			tfSet2P2.setMaxWidth(30);
			tfSet3P1.setMaxWidth(30);
			tfSet3P2.setMaxWidth(30);
			tfSet4P1.setMaxWidth(30);
			tfSet4P2.setMaxWidth(30);
			tfSet5P1.setMaxWidth(30);
			tfSet5P2.setMaxWidth(30);

			btnDone.setMaxWidth(60);

			VBox vbNames = new VBox();
			VBox vbSet1 = new VBox();
			VBox vbSet2 = new VBox();
			VBox vbSet3 = new VBox();
			VBox vbSet4 = new VBox();
			VBox vbSet5 = new VBox();

			vbNames.setSpacing(25);
			vbSet1.setSpacing(20);
			vbSet2.setSpacing(20);
			vbSet3.setSpacing(20);
			vbSet4.setSpacing(20);
			vbSet5.setSpacing(20);

			vbNames.setPadding(new Insets(5, 0, 0, 0));

			vbNames.getChildren().addAll(lblP1, lblP2);
			vbSet1.getChildren().addAll(tfSet1P1, tfSet1P2);
			vbSet2.getChildren().addAll(tfSet2P1, tfSet2P2);
			vbSet3.getChildren().addAll(tfSet3P1, tfSet3P2);
			vbSet4.getChildren().addAll(tfSet4P1, tfSet4P2);
			vbSet5.getChildren().addAll(tfSet5P1, tfSet5P2);

			HBox hbGame = new HBox();
			hbGame.setSpacing(10);
			hbGame.setAlignment(Pos.CENTER);
			hbGame.getChildren().addAll(vbNames, vbSet1, vbSet2, vbSet3, vbSet4, vbSet5);

			vbGame = new VBox();
			vbGame.setAlignment(Pos.CENTER);
			vbGame.setSpacing(25);
			vbGame.getChildren().addAll(lblComp, hbGame, btnDone);

		}

		// Methods
		
		public int[] getPlayerScores(String player) {
			
			if (player.equals(lblP1.getText())) {	// Player 1
				int[] scores = {
						Integer.parseInt(tfSet1P1.getText()),
						Integer.parseInt(tfSet2P1.getText()),
						Integer.parseInt(tfSet3P1.getText()),
						tfSet4P1.getText().equals("") ? 0 : Integer.parseInt(tfSet4P1.getText()),
						tfSet5P1.getText().equals("") ? 0 : Integer.parseInt(tfSet5P1.getText())
				};
				return scores;
			}
			else {	// Player 2
				int[] scores = {
						Integer.parseInt(tfSet1P2.getText()),
						Integer.parseInt(tfSet2P2.getText()),
						Integer.parseInt(tfSet3P2.getText()),
						tfSet4P2.getText().equals("") ? 0 : Integer.parseInt(tfSet4P2.getText()),
						tfSet5P2.getText().equals("") ? 0 : Integer.parseInt(tfSet5P2.getText())
				};
				return scores;
			}
			
		}

	}

}
