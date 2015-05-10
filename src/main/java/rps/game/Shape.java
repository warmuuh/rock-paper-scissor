package rps.game;

import java.util.Optional;

/**
 * describes a Guesture, a player can make during the game
 * 
 * @author pm
 *
 */
public interface Shape {
	public boolean beats(Shape other);

	public Optional<String> getAttackAgainst(Shape other);
}
