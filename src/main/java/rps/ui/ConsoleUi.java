package rps.ui;

import java.util.Scanner;

import rps.game.Shape;

public class ConsoleUi {

	public void start() {
		Shape chosenShape = chooseShape();
		displayMessage("You chose " + chosenShape);
	}

	private Shape chooseShape() {
		Shape chosenShape = null;
		while (chosenShape == null) {
			chosenShape = askForShape();
			if (chosenShape == null) {
				displayMessage("You chose an invalid shape. Please choose again.");
			}
		}
		return chosenShape;
	}

	private Shape askForShape() {
		int input = getInput("Choose: \n 1 - Rock\n 2 - Scissor\n 3 - Paper\n");
		switch (input) {
		case 1:
			return Shape.Rock;
		case 2:
			return Shape.Scissor;
		case 3:
			return Shape.Paper;
		default:
			return null;
		}
	}

	private int getInput(String prompt) {
		displayMessage(prompt);
		try (Scanner scanner = new Scanner(System.in)) {
			int input = scanner.nextInt();
			return input;
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
