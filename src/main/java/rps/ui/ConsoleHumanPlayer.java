package rps.ui;

import static rps.ui.ConsoleIO.*;
import rps.game.Player;
import rps.game.Shape;

public class ConsoleHumanPlayer extends Player {

	public ConsoleHumanPlayer() {
		super("Player");
	}

	private Shape[] availableShapes;

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		this.availableShapes = availableShapes;
		return chooseShape();
	}

	private Shape chooseShape() {
		Shape chosenShape = askForShape();
		displayMessage("You chose " + chosenShape);
		return chosenShape;
	}

	private Shape askForShape() {
		showAvailableChoices();
		Integer input = ConsoleIO.getValidChoice(1, availableShapes.length, "You chose an invalid shape. Please choose again.");
		return getShapeForId(input - 1);
	}

	private void showAvailableChoices() {
		StringBuilder b = new StringBuilder("Choose:\n");
		for (int i = 0; i < availableShapes.length; i++) {
			Shape shape = availableShapes[i];
			b.append(" ").append(i + 1).append(" - ").append(shape.toString()).append("\n");
		}
		displayMessage(b.toString());
	}

	private Shape getShapeForId(int id) {
		return availableShapes[id];
	}

}
