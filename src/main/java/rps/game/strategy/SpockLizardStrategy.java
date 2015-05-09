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

		rock.addToBeaten(scissor);
		rock.addToBeaten(lizard);

		scissor.addToBeaten(paper);
		scissor.addToBeaten(lizard);

		paper.addToBeaten(rock);
		paper.addToBeaten(spock);

		lizard.addToBeaten(spock);
		lizard.addToBeaten(paper);

		spock.addToBeaten(scissor);
		spock.addToBeaten(rock);

		this.availableShapes = new Shape[] { rock, paper, scissor, lizard, spock };

	}

	@Override
	public Shape[] getAvailableShapes() {
		return availableShapes;
	}

}
