package rps.game.mock;

import rps.game.Shape;
import rps.game.strategy.GameStrategy;

public class WinLooseStrategy implements GameStrategy {

	@Override
	public Shape[] getAvailableShapes() {
		return new Shape[] { new WinningShape(), new LoosingShape() };
	}

}
