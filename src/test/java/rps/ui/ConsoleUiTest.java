package rps.ui;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import rps.game.Game;

public class ConsoleUiTest {

	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	@Rule
	public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	private ConsoleUi ui;

	@Before
	public void setup() {
		ui = new ConsoleUi(new Game());
		ui.initialize();
	}

	@Test
	public void uiShouldGreetUser() {
		assertThat(log.getLog(), containsString("Welcome"));
	}

	@Test
	public void bothPlayersChooseAndResultIsDisplayed() {
		systemInMock.provideText("1");
		ui.start();
		assertThat(log.getLog(), containsString("Choose"));
		assertThat(log.getLog(), containsString("You chose"));
		assertThat(log.getLog(), containsString("Computer chose"));
		assertThat(log.getLog(), anyOf(containsString("win"), containsString("tie")));
	}

	@Test
	public void userShouldChoosePvCMode() {
		systemInMock.provideText("1");
		ui.chooseMode();
		assertThat(log.getLog(), containsString("mode"));
		assertThat(log.getLog(), containsString("You chose Player vs. Computer"));
	}

	@Test
	public void userShouldChooseCvCMode() {
		systemInMock.provideText("2");
		ui.chooseMode();
		assertThat(log.getLog(), containsString("mode"));
		assertThat(log.getLog(), containsString("You chose Computer vs. Computer"));
	}
}
