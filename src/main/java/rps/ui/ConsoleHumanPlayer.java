package rps.ui;

import static rps.ui.ConsoleIO.*;

import java.util.InputMismatchException;
import java.util.Scanner;

import rps.game.Player;
import rps.game.Shape;

public class ConsoleHumanPlayer implements Player {

	private Shape[] availableShapes;

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		this.availableShapes = availableShapes;
		return chooseShape();
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

	private Shape askForShape() {
		showPrompt();
		Integer input = getInput();
		if (input == null)
			return null;

		int shapeId = input - 1;
		return getShapeForIdOrNull(shapeId);
	}

	private void showPrompt() {
		StringBuilder b = new StringBuilder("Choose:\n");
		for (int i = 0; i < Shape.values().length; i++) {
			Shape shape = Shape.values()[i];
			b.append(" ").append(i + 1).append(" - ").append(shape.toString()).append("\n");
		}
		displayMessage(b.toString());
	}

	private Shape getShapeForIdOrNull(int id) {
		if (id < 0 || id >= availableShapes.length)
			return null;
		return Shape.values()[id];
	}

	@SuppressWarnings("resource")
	private Integer getInput() {
		Scanner scanner = new Scanner(ConsoleIO.getInputStream());
		try {
			int input = scanner.nextInt();
			return input;
		} catch (InputMismatchException e) {
			return null;
		}

	}

	@Override
	public String getName() {
		return "Player";
	}

}
