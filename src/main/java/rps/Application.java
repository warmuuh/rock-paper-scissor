package rps;

import rps.game.Game;
import rps.game.strategy.ClassicStrategy;
import rps.game.strategy.GameStrategy;
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
		GameStrategy gameStrategy = createStrategy(args);
		Game game = new Game(gameStrategy);
		ConsoleUi ui = new ConsoleUi(game);
		ui.run();
	}

	private static GameStrategy createStrategy(String[] args) {
		if (args.length >= 1 && "lizard".equals(args[0])) {
			return new SpockLizardStrategy();
		}
		return new ClassicStrategy();
	}

}
