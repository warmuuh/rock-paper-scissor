package rps.game;

public class Game {

	public boolean makeMove(Shape moveOfPlayer1, Shape moveOfPalyer2) {
		return moveOfPlayer1.beats(moveOfPalyer2);
	}

}
