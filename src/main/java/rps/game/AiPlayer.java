package rps.game;

import java.util.Random;

/**
 * a rock-paper-scissor AI
 * 
 * @author pm
 *
 */
public abstract class AiPlayer extends Player {

	static private Random rnd = new Random(System.currentTimeMillis());

	public AiPlayer(String name) {
		super(name);
	}

	@Override
	public Shape getChosenShape(Shape[] availableShapes) {
		int maxIdExclusive = availableShapes.length;
		int randomId = rnd.nextInt(maxIdExclusive);
		Shape shape = availableShapes[randomId];
		return shape;
	}

}
