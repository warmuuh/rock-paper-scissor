package rps.game.strategy;

import rps.game.Shape;

/**
 * classic rule-set, i.e. rock, paper, scissor
 * 
 * @author pm
 *
 */
public class ClassicStrategy implements GameStrategy {

	private Shape[] availableShapes;

	public ClassicStrategy() {
		createShapes();
	}

	private void createShapes() {
		DynamicShape rock = new DynamicShape("Rock");
		DynamicShape scissor = new DynamicShape("Scissor");
		DynamicShape paper = new DynamicShape("Paper");

		rock.addAttackAgainst("crushes", scissor);
		scissor.addAttackAgainst("cuts", paper);
		paper.addAttackAgainst("wraps", rock);

		this.availableShapes = new Shape[] { rock, paper, scissor };

	}

	@Override
	public Shape[] getAvailableShapes() {
		return availableShapes;
	}

}
