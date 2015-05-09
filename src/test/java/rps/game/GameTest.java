package rps.game;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testInitialization() {
		Game game = new Game();
		boolean win = game.makeMove(Shape.Rock, Shape.Scissor);
		assertThat(win, is(true));
	}
}
