package rps.game.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import rps.game.Shape;

/**
 * a dynamic shape-description that can be built up during runtime
 * 
 * @author pm
 *
 */
public class DynamicShape implements Shape {

	private final String name;
	private Map<Shape, String> availableAttacks;

	public DynamicShape(String name) {
		super();
		this.name = name;
		availableAttacks = new HashMap<Shape, String>();
	}

	public void addAttackAgainst(String attack, Shape other) {
		availableAttacks.put(other, attack);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean beats(Shape other) {
		return availableAttacks.containsKey(other);
	}

	@Override
	public Optional<String> getAttackAgainst(Shape other) {
		return Optional.ofNullable(availableAttacks.get(other));
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
