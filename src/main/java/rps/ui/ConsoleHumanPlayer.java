package rps.ui;

import static rps.ui.ConsoleIO.*;

import java.util.Optional;

import rps.game.Player;
import rps.game.Shape;

public class ConsoleHumanPlayer implements Player {

	private Shape[] availableShapes;

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		this.availableShapes = availableShapes;
		return chooseShape();
	}

	private Shape chooseShape() {
		Optional<Shape> chosenShape;
		do {
			chosenShape = askForShape();
			if (!chosenShape.isPresent()) {
				displayMessage("You chose an invalid shape. Please choose again.");
			}
		} while (!chosenShape.isPresent());

		Shape shape = chosenShape.get();
		displayMessage("You chose " + shape);
		return shape;
	}

	private Optional<Shape> askForShape() {
		showAvailableChoices();
		Optional<Integer> input = ConsoleIO.tryReadInteger();
		return input.flatMap(in -> {
			int shapeId = in - 1;
			return getShapeForId(shapeId);
		});
	}

	private void showAvailableChoices() {
		StringBuilder b = new StringBuilder("Choose:\n");
		for (int i = 0; i < Shape.values().length; i++) {
			Shape shape = Shape.values()[i];
			b.append(" ").append(i + 1).append(" - ").append(shape.toString()).append("\n");
		}
		displayMessage(b.toString());
	}

	private Optional<Shape> getShapeForId(int id) {
		if (id < 0 || id >= availableShapes.length)
			return Optional.empty();
		return Optional.ofNullable(Shape.values()[id]);
	}

	@Override
	public String getName() {
		return "Player";
	}

}
