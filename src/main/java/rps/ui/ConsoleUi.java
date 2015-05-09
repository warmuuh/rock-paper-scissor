package rps.ui;

import static rps.ui.ConsoleIO.*;
import rps.game.Game;
import rps.game.GameResult;
import rps.game.Player;

public class ConsoleUi {

	private final Game game;
	private Integer rounds;

	public ConsoleUi(Game game) {
		this.game = game;

	}

	public void run() {
		initialize();
		chooseMode();
		chooseRounds();
		startGame();
	}

	/**
	 * initializes game with default values
	 */
	/* package */void initialize() {
		rounds = 1;
		choosePlayerVsComputer();
		printWelcomeScreen();
	}

	/* package */void chooseMode() {
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

	/* package */void chooseRounds() {
		displayMessage("How many rounds should be played?\n");
		rounds = ConsoleIO.getValidChoice(1, 100, "You dont want to play more than 100 rounds, believe me.");
		displayMessage("You chose " + rounds + " rounds.");
	}

	/* package */void startGame() {
		for (int r = 0; r < rounds; ++r) {
			int currentRound = r + 1;
			displayMessage("\nRound " + currentRound);
			GameResult result = game.startRound();
			proclaimWinner(result);
		}
		displayFinalResult();
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

	private void displayFinalResult() {
		Player player1 = game.getPlayer1();
		Player player2 = game.getPlayer2();
		displayMessage("Final Results:\n");
		displayMessage(" Scores of " + player1.getName() + ": " + player1.getScore());
		displayMessage(" Scores of " + player2.getName() + ": " + player2.getScore());
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
