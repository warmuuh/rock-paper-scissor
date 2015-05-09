package rps.game;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import rps.game.mock.LoosingShape;
import rps.game.mock.WinLooseStrategy;
import rps.game.mock.WinningShape;

public class GameTest {

	private Game game;

	@Before
	public void setup() {
		game = new Game(new WinLooseStrategy());
	}

	@Test
	public void player1ShouldWin() {
		GameResult result = game.makeMove(new WinningShape(), new LoosingShape());
		assertThat(result, is(GameResult.Player1Wins));
	}

	@Test
	public void player2ShouldWin() {
		GameResult result = game.makeMove(new LoosingShape(), new WinningShape());
		assertThat(result, is(GameResult.Player2Wins));
	}

	@Test
	public void shouldUnderstandTie() {
		GameResult result = game.makeMove(new WinningShape(), new WinningShape());
		assertThat(result, is(GameResult.Tie));
	}
}
