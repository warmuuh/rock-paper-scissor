package rps.ui;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import rps.game.Shape;
import rps.game.mock.WinLooseStrategy;

public class ConsoleAiPlayerTest {

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	WinLooseStrategy strat = new WinLooseStrategy();

	@Test
	public void shouldChooseRandomShape() {

		ConsoleAiPlayer ai = new ConsoleAiPlayer("Computer");
		Shape shape = ai.getChosenShape(strat.getAvailableShapes());
		assertThat(shape, notNullValue());
		assertThat(log.getLog(), containsString("Computer chose"));
	}

	@Test
	public void shouldChooseAnotherName() {
		ConsoleAiPlayer ai = new ConsoleAiPlayer("Computer1");
		Shape shape = ai.getChosenShape(strat.getAvailableShapes());
		assertThat(shape, notNullValue());
		assertThat(log.getLog(), containsString("Computer1 chose"));
	}
}
