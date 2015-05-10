package rps.game;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import rps.game.mock.Looser;
import rps.game.mock.LoosingShape;
import rps.game.mock.WinLooseStrategy;
import rps.game.mock.Winner;
import rps.game.mock.WinningShape;

public class GameTest {

	private Game game;

	@Before
	public void setup() {
		game = new Game(new WinLooseStrategy());
		game.setPlayer1(new Winner());
		game.setPlayer2(new Looser());
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

	@Test
	public void scoreOfWinnerShouldIncrement() {
		game.startRound();
		assertThat(game.getPlayer1().getScore(), is(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandleInvalidState() {
		Game g = new Game(new WinLooseStrategy());
		g.startRound();

	}
}
