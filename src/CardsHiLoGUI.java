
//standard imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

// imports for layout
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

// Imports for components in this application
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;

// Import for menus 
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
//Imports for pos and insets 
import javafx.geometry.Pos;
import javafx.geometry.Insets;

// Imports for images
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

// Import to support applications quit
import javafx.application.Platform;

public class CardsHiLoGUI extends Application {

	/*
	 * Declaration of variables 
	 */

	// Labels
	Label lblFirstCard, lblSecondCard, lblPrompt, lblResult, lblpBar;

	// Images
	Image imgFirstCard, imgSecondCard;

	// ImageViews
	ImageView imvFirstCard, imvSecondCard;

	// Buttons and radio buttons
	Button btnDealFirst, btnDealSecond;

	RadioButton rdoHigher, rdoLower;

	// Toggle group to group radio buttons. Only one selectable in group.
	ToggleGroup hiloGroup;

	// MenuBar
	MenuBar mBar;

	// menu
	Menu menuFile;
	Menu menuAbout;

	MenuItem mItemNew;
	MenuItem mItemShuffle;
	MenuItem mItemExit;
	MenuItem mItemAbout;

	// Progressbar
	ProgressBar pBar;

	/*
	 * Constructor
	 */
	public CardsHiLoGUI() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * Init method
	 */

	public void init() {

		// create Game
		Game game = new Game();

		// Labels
		lblFirstCard = new Label("First Card Dealt:");
		lblSecondCard = new Label("Second Card Dealt:");
		lblPrompt = new Label("The next Card will be:");
		lblResult = new Label("The result is:");
		lblpBar = new Label("5 correct guesses in a row needed to win");

		// Images
		imgFirstCard = new Image(getClass().getResource("./cards/default.png").toString());

		imgSecondCard = new Image(getClass().getResource("./cards/default.png").toString());

		imvFirstCard = new ImageView(imgFirstCard);
		imvSecondCard = new ImageView(imgSecondCard);

		// Buttons
		btnDealFirst = new Button("<- Deal First Card");
		btnDealFirst.setOnAction(ae -> btnFirstClick(game));

		btnDealSecond = new Button("Deal Second Card ->");

		// Configure button size
		btnDealFirst.setMinWidth(160);
		btnDealSecond.setMinWidth(160);
		btnDealSecond.setDisable(true);
		btnDealSecond.setOnAction(ae -> btnSecondClick(game));

		// Instantiate radio buttons
		rdoHigher = new RadioButton("Higher");
		rdoLower = new RadioButton("Lower");

		hiloGroup = new ToggleGroup();
		rdoHigher.setToggleGroup(hiloGroup);
		rdoLower.setToggleGroup(hiloGroup);
		rdoHigher.setSelected(true);

		// Menu
		mBar = new MenuBar();
		menuFile = new Menu("File");
		menuAbout = new Menu("About");

		// menu item new game
		mItemNew = new MenuItem("New game");
		mItemNew.setOnAction(ae -> gameStart(game));

		// menu item exit game
		mItemExit = new MenuItem("Exit");
		mItemExit.setOnAction(ae -> Platform.exit());

		// menu item about
		mItemAbout = new MenuItem("About");
		mItemAbout.setOnAction(ae -> showAbout());

		// add menus to menu bar
		mBar.getMenus().add(menuFile);
		mBar.getMenus().add(menuAbout);

		// add entries to menu
		menuFile.getItems().add(mItemNew);
		menuFile.getItems().add(mItemExit);
		menuAbout.getItems().add(mItemAbout);

		// Progress bar
		pBar = new ProgressBar(0);
		pBar.setPrefWidth(480);

	}// init

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set the title
		primaryStage.setTitle("Cards HiLo Game");

		// Create a layout
		GridPane gp = new GridPane();

		gp.add(lblFirstCard, 0, 0);
		gp.add(lblSecondCard, 2, 0);
		gp.add(lblPrompt, 1, 1);

		// Vbox
		VBox playButtonBox = new VBox();
		VBox vBoxMain = new VBox();
		VBox vBoxUpper = new VBox();

		vBoxUpper.getChildren().add(lblpBar);
		vBoxUpper.getChildren().add(pBar);

		vBoxMain.getChildren().add(mBar);
		vBoxMain.getChildren().add(vBoxUpper);
		vBoxMain.getChildren().add(gp);

		// Padding & Spacing
		gp.setVgap(10);
		gp.setHgap(10);
		gp.setAlignment(Pos.BASELINE_CENTER);
		gp.setPadding(new Insets(10));

		playButtonBox.setPadding(new Insets(5));
		vBoxUpper.setPadding(new Insets(10));
		playButtonBox.setSpacing(5);
		vBoxUpper.setSpacing(5);

		// add images
		gp.add(imvFirstCard, 0, 1);
		gp.add(imvSecondCard, 2, 1);

		playButtonBox.getChildren().add(lblPrompt);
		playButtonBox.getChildren().add(rdoHigher);
		playButtonBox.getChildren().add(rdoLower);
		playButtonBox.getChildren().add(btnDealFirst);
		playButtonBox.getChildren().add(btnDealSecond);

		gp.add(playButtonBox, 1, 1);

		// Create a scene
		Scene scene = new Scene(vBoxMain, 500, 350);
		scene.getStylesheets().add("./stylesheet.css");
		// Set the scene
		primaryStage.setScene(scene);

		// Show the stage
		primaryStage.show();

	}

	public void stop() {

	}// stop

	/*
	 * About menu item 
	 */
	public void showAbout() {

		// create stage
		Stage stageAbout = new Stage();

		// set title
		stageAbout.setTitle("About");

		// create vbox and label for stage
		VBox vBoxAbout = new VBox();

		vBoxAbout.setPadding(new Insets(10));
		vBoxAbout.setAlignment(Pos.TOP_CENTER);

		// create button ok and Label
		Button btnOK = new Button("OK");

		// Create and style label for about box
		Label lblAbout = new Label("Game designed by Nora Limbourg,\nStudentNo: 2880885");
		lblAbout.setPadding(new Insets(10));
		lblAbout.setTextAlignment(TextAlignment.CENTER);

		// add label and button to about box
		vBoxAbout.getChildren().add(lblAbout);
		vBoxAbout.getChildren().add(btnOK);

		// when button clicked, close about box
		btnOK.setOnAction(ae -> stageAbout.close());

		// create scene
		Scene sceneAbout = new Scene(vBoxAbout);
		sceneAbout.getStylesheets().add("./stylesheet.css");

		// set scene
		stageAbout.setScene(sceneAbout);

		// show stage
		stageAbout.show();

	} // show about

	/*
	 * Method to handle end of game
	 */
	public void alertGameEnd(Game game) {
		// create stage
		Stage stageAlert = new Stage();

		// set title
		stageAlert.setTitle("Alert");

		// create vbox and label for stage
		VBox vBoxAlert = new VBox();

		vBoxAlert.setPadding(new Insets(10));
		vBoxAlert.setAlignment(Pos.TOP_CENTER);

		// create button ok and Label
		Button btnOK = new Button("OK");

		Label lblAlert = new Label("You ran out of cards. Start new Game");
		lblAlert.setPadding(new Insets(10));
		lblAlert.setTextAlignment(TextAlignment.CENTER);

		vBoxAlert.getChildren().add(lblAlert);
		vBoxAlert.getChildren().add(btnOK);

		// close dialog when ok button is clicked
		btnOK.setOnAction(ae -> {
			game.restart();
			stageAlert.close();
		});

		// create scene
		Scene sceneAlert = new Scene(vBoxAlert);
		sceneAlert.getStylesheets().add("./stylesheet.css");

		// set scene
		stageAlert.setScene(sceneAlert);

		// show stage
		stageAlert.show();

	} // show alert

	/*
	 * Method to show a dialog with a message (wrong/correct)
	 */
	public void showMessage(String message, Game game) {
		// create stage
		Stage stageMessage = new Stage();

		// set title
		stageMessage.setTitle("Info");

		// create vbox and label for stage
		VBox vBoxMessage = new VBox();

		vBoxMessage.setPadding(new Insets(10));
		vBoxMessage.setAlignment(Pos.TOP_CENTER);
		vBoxMessage.setMinWidth(150);

		// create button ok and Label
		Button btnOK = new Button("OK");

		// create and style label
		Label lblMessage = new Label(message);
		lblMessage.setPadding(new Insets(10));
		lblMessage.setTextAlignment(TextAlignment.CENTER);

		// add label to vbox
		vBoxMessage.getChildren().add(lblMessage);
		vBoxMessage.getChildren().add(btnOK);

		// on click close dialog
		btnOK.setOnAction(ae -> {
			btnFirstClick(game);
			stageMessage.close();
		});

		// create scene
		Scene sceneMessage = new Scene(vBoxMessage);
		sceneMessage.getStylesheets().add("./stylesheet.css");

		// set scene
		stageMessage.setScene(sceneMessage);

		// show stage
		stageMessage.show();

	} // show Message

	// when the first button is clicked
	public void btnFirstClick(Game game) {

		// print out current and next card for debugging
		// System.out.println("Current Card before dealing card 1: " +
		// game.getDeck().getCurrentCard());
		// System.out.println("Next Card before dealing card 1: " +
		// game.getDeck().getNextCard());

		// take a card from the top of the deck
		Card card = game.getDeck().dealTopCard();

		// store the card in firstCard variable
		game.getDeck().setFirstCard(card);
		// System.out.println("First card: "+ card.toString());

		// change image to display the first card
		Image img1 = new Image(getClass().getResource(card.toString()).toString());
		imvFirstCard.setImage(img1);

		// show default image in second card imageview
		Image img2 = new Image(getClass().getResource("./cards/default.png").toString());
		imvSecondCard.setImage(img2);

		// disable button 1 and enable button 2
		btnDealFirst.setDisable(true);
		btnDealSecond.setDisable(false);

		// print for debugging
		// System.out.println("Current Card after dealing card 1: " +
		// game.getDeck().getCurrentCard());
		// System.out.println("Next Card after dealing card 1: " +
		// game.getDeck().getNextCard());

	} // buttonFirstClick

	public void btnSecondClick(Game game) {

		// when second button is clicked
		// deal top card
		Card card = game.getDeck().dealTopCard();
		System.out.println("Second Card: " + card.toString());

		// store card in variable secondCard
		game.getDeck().setSecondCard(card);

		// show image of second card
		Image img2 = new Image(getClass().getResource(card.toString()).toString());
		imvSecondCard.setImage(img2);

		// disable second button and enable first
		btnDealSecond.setDisable(true);
		btnDealFirst.setDisable(false);
		System.out.println("Current Card after dealing second card: " + game.getDeck().getCurrentCard());
		System.out.println("Next Card after dealing second card: " + game.getDeck().getNextCard());

		// variable to store a win
		boolean isWinner = false;
		// if radiobutton lower is selected, evaluate win for this situation
		if (rdoLower.isSelected()) {
			if (game.evaluateWin(0) == true) {
				isWinner = true;
			}
			// if radiobutton higher is selected, evaluate win for this
			// situation
		} else if (rdoHigher.isSelected()) {
			if (game.evaluateWin(1) == true) {
				isWinner = true;
			}
			;
		}
		// if player won, but win counter has not reached 5, show message
		// correct
		if (isWinner == true && (game.getWinCounter() < 5)) {

			showMessage("Correct", game);

			// else show message wrong
		} else if (isWinner == false) {
			showMessage("Wrong", game);

		}

		// update progress bar with win counter value
		pBar.setProgress((double) game.getWinCounter() / 5);
		// if user won 5 times, show message and restart game
		if (game.getWinCounter() == 5) {
			showMessage("You won the game. Play again", game);
			gameStart(game);

		}

		// check if deck is empty, if so alert end of game
		if (game.getDeck().isEmpty() == true) {
			alertGameEnd(game);
			// restart game
			gameStart(game);
		}

	}// btnSecondClick()

	/*
	 * Method to start a game
	 */
	public void gameStart(Game game) {
		// reset all counters
		game.restart();

		// replace both imv with default image
		Image img = new Image(getClass().getResource("./cards/default.png").toString());
		imvFirstCard.setImage(img);
		imvSecondCard.setImage(img);
		// reset buttons and progress bar
		btnDealSecond.setDisable(true);
		btnDealFirst.setDisable(false);
		pBar.setProgress(0);
		
	}// gamestart()

	public static void main(String[] args) {
		// launch the application

		launch(args);

	}// main

}// class
