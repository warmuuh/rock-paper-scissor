package rps.game.mock;

import java.util.Optional;

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

	@Override
	public Optional<String> getAttackAgainst(Shape other) {
		return Optional.empty();
	}

}
