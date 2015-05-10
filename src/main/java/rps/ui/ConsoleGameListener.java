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
		player1Move.getAttackAgainst(player2Move).ifPresent(attack -> {
			displayMessage(player1Move + " " + attack + " " + player2Move);
		});
		displayMessage(game.getPlayer1().getName() + " wins!");
	}

	@Override
	public void onPlayer2Won(Shape player1Move, Shape player2Move) {
		player2Move.getAttackAgainst(player1Move).ifPresent(attack -> {
			displayMessage(player2Move + " " + attack + " " + player1Move);
		});
		displayMessage(game.getPlayer2().getName() + " wins!");
	}

}
