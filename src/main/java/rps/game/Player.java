package rps.game;

public interface Player {
	public Shape getChosenShape(Shape[] availableShapes);

	public String getName();
}
