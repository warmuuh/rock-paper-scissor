package rps.game;

public interface GameEventListener {

	public void onTie(Shape player1Move, Shape player2Move);

	public void onPlayer1Won(Shape player1Move, Shape player2Move);

	public void onPlayer2Won(Shape player1Move, Shape player2Move);
}
