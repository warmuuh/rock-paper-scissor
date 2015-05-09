package rps.ui;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;

import rps.game.mock.WinLooseStrategy;

@RunWith(JUnitParamsRunner.class)
public class ConsoleHumanPlayerTest {

	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	private ConsoleHumanPlayer player;

	WinLooseStrategy strat = new WinLooseStrategy();

	@Before
	public void setup() {
		player = new ConsoleHumanPlayer();
	}

	@Test
	@Parameters({ "1, Win", "2, Loose" })
	@TestCaseName("{0} is {1}")
	public void playerShouldChooseRock(String input, String expected) {
		systemInMock.provideText(input);

		player.getChosenShape(strat.getAvailableShapes());

		assertThat(log.getLog(), containsString("Choose"));
		assertThat(log.getLog(), containsString("You chose " + expected));
	}

	@Test
	public void shouldHandleInvalidMove() {
		systemInMock.provideText("9\n", "1\n");

		player.getChosenShape(strat.getAvailableShapes());

		assertThat(log.getLog(), containsString("Choose"));
		assertThat(log.getLog(), containsString("invalid"));
	}

	@Test
	public void shouldHandleInvalidInput() {
		systemInMock.provideText("XX\n", "1\n");

		player.getChosenShape(strat.getAvailableShapes());

		assertThat(log.getLog(), containsString("Choose"));
		assertThat(log.getLog(), containsString("invalid"));
	}

}
