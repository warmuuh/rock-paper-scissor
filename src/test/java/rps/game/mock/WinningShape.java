package rps.game.mock;

import rps.game.Shape;

public class WinningShape implements Shape {

	@Override
	public boolean beats(Shape other) {
		return true;
	}

	@Override
	public String toString() {
		return "Win";
	}
}
