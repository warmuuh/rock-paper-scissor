package rps;

import rps.game.Game;
import rps.game.strategy.SpockLizardStrategy;
import rps.ui.ConsoleUi;

/**
 * wires together the application and runs it
 * 
 * @author pm
 *
 */
public class Application {

	public static void main(String[] args) {
		SpockLizardStrategy gameStrategy = new SpockLizardStrategy();
		Game game = new Game(gameStrategy);
		ConsoleUi ui = new ConsoleUi(game);
		ui.run();
	}

}
