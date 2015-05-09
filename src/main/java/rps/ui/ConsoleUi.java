package rps.ui;

import static rps.ui.ConsoleIO.*;
import rps.game.Game;
import rps.game.GameResult;

public class ConsoleUi {

	private final Game game;

	public ConsoleUi(Game game) {
		this.game = game;

	}

	/**
	 * initializes game with default values
	 */
	public void initialize() {
		choosePlayerVsComputer();
		printWelcomeScreen();
	}

	public void chooseMode() {
		displayMessage("Choose a mode:\n 1 - Player vs. Computer\n 2 - Computer vs. Computer");
		Integer mode = askForMode();
		if (mode == 1) {
			displayMessage("You chose Player vs. Computer");
			choosePlayerVsComputer();
		} else {
			displayMessage("You chose Computer vs. Computer");
			chooseComuterVsComputer();
		}
	}

	private void chooseComuterVsComputer() {
		game.setPlayer1(new ConsoleAiPlayer("Computer 1"));
		game.setPlayer2(new ConsoleAiPlayer("Computer 2"));
	}

	private void choosePlayerVsComputer() {
		game.setPlayer1(new ConsoleHumanPlayer());
		game.setPlayer2(new ConsoleAiPlayer("Computer"));
	}

	private Integer askForMode() {
		return ConsoleIO.getValidChoice(1, 2, "invalid mode. please choose again.");
	}

	public void start() {
		GameResult result = game.startRound();
		proclaimWinner(result);
	}

	private void proclaimWinner(GameResult result) {
		switch (result) {
		case Player1Wins:
			displayMessage(game.getPlayer1().getName() + " wins!");
			break;
		case Player2Wins:
			displayMessage(game.getPlayer2().getName() + " wins!");
			break;
		case Tie:
			displayMessage("Its a tie!");
			break;
		default:
		}
	}

	private void printWelcomeScreen() {
		displayMessage("Welcome to Rock, Paper and Scissor");
	}

}
