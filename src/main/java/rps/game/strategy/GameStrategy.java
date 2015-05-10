package rps.game.strategy;

import rps.game.Shape;

/**
 * a gamestrategy describes available shapes in the game and their relation to
 * each other (by defining the shapes)
 * 
 * @author pm
 *
 */
public interface GameStrategy {

	public Shape[] getAvailableShapes();
}
