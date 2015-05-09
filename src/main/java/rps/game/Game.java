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
		Shape player1Choice = player1.getChosenShape(getAvailableShapes());
		Shape player2Choice = player2.getChosenShape(getAvailableShapes());
		return makeMove(player1Choice, player2Choice);
	}

	private Shape[] getAvailableShapes() {
		return gameStrategy.getAvailableShapes();
	}

	public GameResult makeMove(Shape moveOfPlayer1, Shape moveOfPlayer2) {
		boolean pl1Beats2 = moveOfPlayer1.beats(moveOfPlayer2);
		boolean pl2Beats1 = moveOfPlayer2.beats(moveOfPlayer1);

		if (pl1Beats2 && pl2Beats1 || !pl1Beats2 && !pl2Beats1) {
			return GameResult.Tie;
		}

		if (pl1Beats2) {
			return GameResult.Player1Wins;
		}
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
