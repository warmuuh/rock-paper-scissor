package rps;

import rps.game.Game;
import rps.game.strategy.SpockLizardStrategy;
import rps.ui.ConsoleUi;

public class Application {

	public static void main(String[] args) {
		Game game = new Game(new SpockLizardStrategy());
		ConsoleUi ui = new ConsoleUi(game);
		ui.initialize();
		ui.chooseMode();
		ui.start();
	}

}
