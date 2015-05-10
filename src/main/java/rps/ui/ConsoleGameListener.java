package rps.ui;

import static rps.ui.ConsoleIO.*;
import rps.game.Game;
import rps.game.GameEventListener;
import rps.game.Shape;

public class ConsoleGameListener implements GameEventListener {

	private final Game game;

	public ConsoleGameListener(Game game) {
		super();
		this.game = game;
	}

	@Override
	public void onTie(Shape player1Move, Shape player2Move) {
		displayMessage("Its a tie!");
	}

	@Override
	public void onPlayer1Won(Shape player1Move, Shape player2Move) {
		displayMessage(game.getPlayer1().getName() + " wins!");
	}

	@Override
	public void onPlayer2Won(Shape player1Move, Shape player2Move) {
		displayMessage(game.getPlayer2().getName() + " wins!");
	}

}
