package rps.game.mock;

import rps.game.Player;
import rps.game.Shape;

public class Looser extends Player {
	public Looser() {
		super("Looser");
	}

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		return new LoosingShape();
	}
}