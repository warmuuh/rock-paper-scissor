package rps.ui;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import rps.game.Game;
import rps.game.Shape;

public class ConsoleUi {

	private final Game game;

	public ConsoleUi(Game game) {
		this.game = game;
	}

	public void start() {
		Shape playerShape = chooseShape();
		Shape computerShape = chooseRandomShape();
		decideWinner(playerShape, computerShape);
	}

	private void decideWinner(Shape playerShape, Shape computerShape) {
		if (playerShape.beats(computerShape)) {
			displayMessage("Player wins!");
		} else if (computerShape.beats(playerShape)) {
			displayMessage("Computer wins!");
		} else {
			displayMessage("Its a tie!");
		}
	}

	/* package */Shape chooseShape() {
		Shape chosenShape = null;
		while (chosenShape == null) {
			chosenShape = askForShape();
			if (chosenShape == null) {
				displayMessage("You chose an invalid shape. Please choose again.");
			}
		}
		displayMessage("You chose " + chosenShape);
		return chosenShape;
	}

	/* package */Shape chooseRandomShape() {
		int maxIdExclusive = Shape.values().length;
		Random rnd = new Random(System.currentTimeMillis());
		int randomId = rnd.nextInt(maxIdExclusive);
		Shape shape = getShapeForIdOrNull(randomId);

		displayMessage("Computer chose " + shape);
		return shape;
	}

	private Shape askForShape() {
		Integer input = getInput("Choose: \n 1 - Rock\n 2 - Scissor\n 3 - Paper\n");
		if (input == null)
			return null;

		int shapeId = input - 1;
		return getShapeForIdOrNull(shapeId);
	}

	private Shape getShapeForIdOrNull(int id) {
		if (id < 0 || id >= Shape.values().length)
			return null;
		return Shape.values()[id];
	}

	@SuppressWarnings("resource")
	private Integer getInput(String prompt) {
		displayMessage(prompt);
		Scanner scanner = new Scanner(System.in);
		try {
			int input = scanner.nextInt();
			return input;
		} catch (InputMismatchException e) {
			return null;
		}

	}

	private void printWelcomeScreen() {
		displayMessage("Welcome to Rock, Paper and Scissor");
	}

	private void displayMessage(String string) {
		System.out.println(string);
	}

	public void initialize() {
		printWelcomeScreen();
	}

}
