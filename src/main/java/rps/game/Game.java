package rps.game;

import rps.game.strategy.GameStrategy;

public class Game {

	Player player1;
	Player player2;
	final GameStrategy gameStrategy;

	public Game(GameStrategy gameStrategy) {
		super();
		this.gameStrategy = gameStrategy;
	}

	public GameResult startRound() {
		if (gameStrategy == null) {
			throw new IllegalArgumentException("gamestrategy must not be null");
		}
		if (player1 == null || player2 == null) {
			throw new IllegalArgumentException("player must not be null");
		}

		Shape[] allShapes = gameStrategy.getAvailableShapes();
		Shape player1Choice = player1.getChosenShape(allShapes);
		Shape player2Choice = player2.getChosenShape(allShapes);

		return makeMove(player1Choice, player2Choice);
	}

	/* package */GameResult makeMove(Shape moveOfPlayer1, Shape moveOfPlayer2) {
		boolean pl1Beats2 = moveOfPlayer1.beats(moveOfPlayer2);
		boolean pl2Beats1 = moveOfPlayer2.beats(moveOfPlayer1);

		if (pl1Beats2 && pl2Beats1 || !pl1Beats2 && !pl2Beats1) {
			return GameResult.Tie;
		}

		if (pl1Beats2) {
			player1.incrementScore();
			return GameResult.Player1Wins;
		}

		player2.incrementScore();
		return GameResult.Player2Wins;

	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

}
