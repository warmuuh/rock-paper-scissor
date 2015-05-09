package rps.game;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class GameTest {

	private Game game;

	@Before
	public void setup() {
		game = new Game();
	}

	@Test
	@Parameters({ "Rock, Scissor", "Scissor, Paper", "Paper, Rock" })
	@TestCaseName("{0} beats {1}")
	public void shouldBeat(Shape first, Shape second) {
		GameResult result = game.makeMove(first, second);
		assertThat(result, is(GameResult.Player1Wins));
	}

	@Test
	@Parameters({ "Scissor, Rock", "Paper, Scissor", "Rock, Paper" })
	@TestCaseName("{0} is beaten by {1}")
	public void shouldLose(Shape first, Shape second) {
		GameResult result = game.makeMove(first, second);
		assertThat(result, is(GameResult.Player2Wins));
	}

}
