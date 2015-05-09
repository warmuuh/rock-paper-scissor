package rps.game;

public class Game {

	Player player1;
	Player player2;

	public GameResult startRound() {
		Shape player1Choice = player1.getChosenShape(Shape.values());
		Shape player2Choice = player2.getChosenShape(Shape.values());
		return makeMove(player1Choice, player2Choice);
	}

	public GameResult makeMove(Shape moveOfPlayer1, Shape moveOfPlayer2) {
		if (moveOfPlayer1.beats(moveOfPlayer2)) {
			return GameResult.Player1Wins;
		} else if (moveOfPlayer2.beats(moveOfPlayer1)) {
			return GameResult.Player2Wins;
		}

		return GameResult.Tie;
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
