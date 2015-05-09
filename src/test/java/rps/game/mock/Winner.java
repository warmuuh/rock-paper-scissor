package rps.game.mock;

import rps.game.Player;
import rps.game.Shape;

public class Winner extends Player {
	public Winner() {
		super("Winner");
	}

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		return new WinningShape();
	}
}