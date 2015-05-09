package rps.game;

import java.util.Random;

/**
 * a rock-paper-scissor AI
 * 
 * @author pm
 *
 */
public abstract class AiPlayer implements Player {

	static private Random rnd = new Random(System.currentTimeMillis());

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		int maxIdExclusive = Shape.values().length;
		int randomId = rnd.nextInt(maxIdExclusive);
		Shape shape = availableShapes[randomId];
		return shape;
	}

}
