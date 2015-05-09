package rps.game;

public abstract class Player {
	private final String name;
	private int score;

	public Player(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void incrementScore() {
		score += 1;
	}

	public int getScore() {
		return score;
	}

	public abstract Shape getChosenShape(Shape[] availableShapes);
}
