package rps.game;

/**
 * describes a Guesture, a player can make during the game
 * 
 * @author pm
 *
 */
public interface Shape {
	public boolean beats(Shape other);
}
