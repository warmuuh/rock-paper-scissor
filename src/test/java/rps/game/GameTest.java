package rps.game;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

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
		GameEventListener evtListener = mock(GameEventListener.class);
		game.addListener(evtListener);
		game.makeMove(new WinningShape(), new LoosingShape());
		verify(evtListener).onPlayer1Won(any(Shape.class), any(Shape.class));
	}

	@Test
	public void player2ShouldWin() {
		GameEventListener evtListener = mock(GameEventListener.class);
		game.addListener(evtListener);
		game.makeMove(new LoosingShape(), new WinningShape());
		verify(evtListener).onPlayer2Won(any(Shape.class), any(Shape.class));
	}

	@Test
	public void shouldUnderstandTie() {
		GameEventListener evtListener = mock(GameEventListener.class);
		game.addListener(evtListener);
		game.makeMove(new WinningShape(), new WinningShape());
		verify(evtListener).onTie(any(Shape.class), any(Shape.class));
	}

	@Test
	public void scoreOfWinnerShouldIncrement() {
		game.startRound();
		assertEquals(1, game.getPlayer1().getScore());
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldHandleInvalidState() {
		Game g = new Game(new WinLooseStrategy());
		g.startRound();

	}
}
