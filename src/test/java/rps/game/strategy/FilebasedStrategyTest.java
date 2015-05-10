package rps.game.strategy;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import rps.game.Shape;

public class FilebasedStrategyTest {

	@Test
	public void strategyShouldLoadFile() {
		FilebasedStrategy strat = new FilebasedStrategy("rps11.txt");
		assertNotNull(strat.getAvailableShapes());
	}

	@Test(expected = RuntimeException.class)
	public void strategyShouldHandleMissingFile() {
		new FilebasedStrategy("nonexistant.txt");
	}

	@Test
	public void strategyShouldReturn11Shapes() {
		FilebasedStrategy strat = new FilebasedStrategy("rps11.txt");
		assertThat(strat.getAvailableShapes().length, is(11));
	}

	@Test
	public void firstShapeShouldBeatNext5Ones() {
		FilebasedStrategy strat = new FilebasedStrategy("rps11.txt");
		Shape[] shapes = strat.getAvailableShapes();
		Shape firstShape = shapes[0];
		for (int i = 1; i < 6; ++i) {
			assertThat(firstShape.beats(shapes[i]), is(true));
		}
	}

	@Test
	public void firstShapeShouldNotBeatAnyOtherShapes() {
		FilebasedStrategy strat = new FilebasedStrategy("rps11.txt");
		Shape[] shapes = strat.getAvailableShapes();
		Shape firstShape = shapes[0];
		for (int i = 6; i < 11; ++i) {
			assertThat(firstShape.beats(shapes[i]), is(false));
		}
	}
}
