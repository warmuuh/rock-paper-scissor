package rps.game.strategy;

import java.util.LinkedList;
import java.util.List;

import rps.game.Shape;

public class DynamicShape implements Shape {

	private final String name;
	private List<Shape> beatenShapes;

	public DynamicShape(String name) {
		super();
		this.name = name;
		beatenShapes = new LinkedList<Shape>();
	}

	public void addToBeaten(Shape other) {
		beatenShapes.add(other);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean beats(Shape other) {
		return beatenShapes.contains(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DynamicShape other = (DynamicShape) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
