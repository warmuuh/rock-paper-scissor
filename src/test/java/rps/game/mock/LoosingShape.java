package rps.game.mock;

import rps.game.Shape;

public class LoosingShape implements Shape {

	@Override
	public boolean beats(Shape other) {
		return false;
	}

	@Override
	public String toString() {
		return "Loose";
	}

}
