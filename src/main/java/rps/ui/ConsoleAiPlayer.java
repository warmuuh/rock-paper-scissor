package rps.ui;

import static rps.ui.ConsoleIO.*;
import rps.game.AiPlayer;
import rps.game.Shape;

public class ConsoleAiPlayer extends AiPlayer {

	final String name;

	public ConsoleAiPlayer(String name) {
		super();
		this.name = name;
	}

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		Shape chosenShape = super.getChosenShape(availableShapes);
		displayMessage(name + " chose " + chosenShape);
		return chosenShape;
	}

	@Override
	public String getName() {
		return name;
	}

}
