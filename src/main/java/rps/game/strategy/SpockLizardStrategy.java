package rps.game.strategy;

import rps.game.Shape;

/**
 * spock-lizard as additional shapes see
 * http://en.wikipedia.org/wiki/Rock-paper-scissors#Additional_weapons
 * 
 * @author pm
 *
 */
public class SpockLizardStrategy implements GameStrategy {

	private Shape[] availableShapes;

	public SpockLizardStrategy() {
		createShapes();
	}

	private void createShapes() {
		DynamicShape rock = new DynamicShape("Rock");
		DynamicShape scissor = new DynamicShape("Scissor");
		DynamicShape paper = new DynamicShape("Paper");
		DynamicShape lizard = new DynamicShape("Lizard");
		DynamicShape spock = new DynamicShape("Spock");

		rock.addAttackAgainst("crushes", scissor);
		rock.addAttackAgainst("crushes", lizard);

		scissor.addAttackAgainst("cuts", paper);
		scissor.addAttackAgainst("decapitates", lizard);

		paper.addAttackAgainst("wraps", rock);
		paper.addAttackAgainst("disproves", spock);

		lizard.addAttackAgainst("poisons", spock);
		lizard.addAttackAgainst("eats", paper);

		spock.addAttackAgainst("smashes", scissor);
		spock.addAttackAgainst("vaporizes", rock);

		this.availableShapes = new Shape[] { rock, paper, scissor, lizard, spock };

	}

	@Override
	public Shape[] getAvailableShapes() {
		return availableShapes;
	}

}
