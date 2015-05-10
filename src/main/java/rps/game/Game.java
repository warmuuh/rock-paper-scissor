package rps.game;

import java.util.LinkedList;
import java.util.List;

import rps.game.strategy.GameStrategy;

public class Game {

	Player player1;
	Player player2;
	final GameStrategy gameStrategy;
	final List<GameEventListener> listeners;

	public Game(GameStrategy gameStrategy) {
		super();
		this.gameStrategy = gameStrategy;
		listeners = new LinkedList<GameEventListener>();
	}

	public void startRound() {
		if (gameStrategy == null) {
			throw new IllegalArgumentException("gamestrategy must not be null");
		}
		if (player1 == null || player2 == null) {
			throw new IllegalArgumentException("player must not be null");
		}

		Shape[] allShapes = gameStrategy.getAvailableShapes();
		Shape player1Choice = player1.getChosenShape(allShapes);
		Shape player2Choice = player2.getChosenShape(allShapes);

		makeMove(player1Choice, player2Choice);
	}

	/* package */void makeMove(Shape moveOfPlayer1, Shape moveOfPlayer2) {
		boolean pl1Beats2 = moveOfPlayer1.beats(moveOfPlayer2);
		boolean pl2Beats1 = moveOfPlayer2.beats(moveOfPlayer1);

		if (pl1Beats2 && pl2Beats1 || !pl1Beats2 && !pl2Beats1) {
			notifyListenersOnTie(moveOfPlayer1, moveOfPlayer2);
		} else if (pl1Beats2) {
			player1.incrementScore();
			notifyListenersOnPlayer1Won(moveOfPlayer1, moveOfPlayer2);
		} else {
			player2.incrementScore();
			notifyListenersOnPlayer2Won(moveOfPlayer1, moveOfPlayer2);
		}
	}

	public void addListener(GameEventListener listener) {
		listeners.add(listener);
	}

	private void notifyListenersOnTie(Shape player1Shape, Shape player2Shape) {
		for (GameEventListener listener : listeners) {
			listener.onTie(player1Shape, player2Shape);
		}
	}

	private void notifyListenersOnPlayer1Won(Shape player1Shape, Shape player2Shape) {
		for (GameEventListener listener : listeners) {
			listener.onPlayer1Won(player1Shape, player2Shape);
		}
	}

	private void notifyListenersOnPlayer2Won(Shape player1Shape, Shape player2Shape) {
		for (GameEventListener listener : listeners) {
			listener.onPlayer2Won(player1Shape, player2Shape);
		}
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
