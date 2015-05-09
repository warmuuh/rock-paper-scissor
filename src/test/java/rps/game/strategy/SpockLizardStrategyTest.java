package rps.game.strategy;

import static org.junit.Assert.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;

import org.junit.Test;
import org.junit.runner.RunWith;

import rps.game.Shape;

@RunWith(JUnitParamsRunner.class)
public class SpockLizardStrategyTest {

	SpockLizardStrategy strategy = new SpockLizardStrategy();

	@Test
	@Parameters({ "Rock, Scissor", "Scissor, Paper", "Paper, Rock", "Lizard, Spock", "Spock, Rock" })
	@TestCaseName("{0} beats {1}")
	public void testWinnings(String first, String other) {
		Shape firstShape = getShape(first);
		Shape otherShape = getShape(other);
		assertTrue(first + " beats " + other, firstShape.beats(otherShape));
	}

	@Test
	@Parameters({ "Rock, Paper", "Paper, Scissor", "Scissor, Rock", "Spock, Lizard", "Paper, Lizard" })
	@TestCaseName("{0} is beaten by {1}")
	public void testLoosing(String first, String other) {
		Shape firstShape = getShape(first);
		Shape otherShape = getShape(other);
		assertTrue(first + " is beaten by " + other, otherShape.beats(firstShape));
	}

	private Shape getShape(String shapeName) {
		for (Shape shape : strategy.getAvailableShapes()) {
			if (shape.toString().equals(shapeName)) {
				return shape;
			}
		}
		throw new AssertionError("Failed to find shape: " + shapeName);
	}

}
