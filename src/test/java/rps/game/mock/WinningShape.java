package rps.game.mock;

import java.util.Optional;

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

	@Override
	public Optional<String> getAttackAgainst(Shape other) {
		return Optional.of("crushes");
	}
}
