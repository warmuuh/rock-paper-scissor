package rps;

import rps.game.Game;
import rps.ui.ConsoleUi;

public class Application {

	public static void main(String[] args) {

		Game game = new Game();
		ConsoleUi ui = new ConsoleUi(game);
		ui.initialize();
		ui.start();
	}

}
