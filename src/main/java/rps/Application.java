package rps;

import rps.game.Game;
import rps.game.strategy.ClassicStrategy;
import rps.ui.ConsoleUi;

public class Application {

	public static void main(String[] args) {
		Game game = new Game(new ClassicStrategy());
		ConsoleUi ui = new ConsoleUi(game);
		ui.initialize();
		ui.chooseMode();
		ui.start();
	}

}
