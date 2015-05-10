package rps.game.strategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import rps.game.Shape;

/**
 * reads a set of names from a file and creates a dynamic game from it. it uses
 * hereby the circumstance, that 1 guesture beats the next (n-1)/2 ones
 * 
 * @author pm
 *
 */
public class FilebasedStrategy implements GameStrategy {

	private DynamicShape[] availableShapes;

	public FilebasedStrategy(String fileName) {
		createShapes(fileName);
	}

	private void createShapes(String fileName) {
		List<String> names = loadNames(fileName);

		verifyNames(names);

		createAllShapeDefinitions(names);
		defineAttacks();
	}

	private void verifyNames(List<String> names) {
		if (names.size() % 2 == 0) {
			throw new IllegalArgumentException("Count of names has to be odd.");
		}
	}

	private void defineAttacks() {
		int nBeaten = (availableShapes.length - 1) / 2;

		for (int curShape = 0; curShape < availableShapes.length; curShape++) {
			DynamicShape shape = availableShapes[curShape];
			for (int offset = 1; offset <= nBeaten; offset++) {
				int nextShapeId = (curShape + offset) % availableShapes.length;
				shape.addAttackAgainst("beats", availableShapes[nextShapeId]);
			}
		}
	}

	private void createAllShapeDefinitions(List<String> names) {
		availableShapes = new DynamicShape[names.size()];
		for (int i = 0; i < names.size(); i++) {
			String shapeName = names.get(i);
			availableShapes[i] = new DynamicShape(shapeName);
		}
	}

	private List<String> loadNames(String fileName) {
		List<String> names = new LinkedList<String>();

		try (BufferedReader br = openResource(fileName)) {
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				names.add(line.trim());
			}
		} catch (IOException e) {
			throw new RuntimeException("Failed to read file: " + fileName);
		}

		return names;
	}

	private BufferedReader openResource(String fileName) throws FileNotFoundException {
		InputStream inputStream = this.getClass().getResourceAsStream("/" + fileName);
		if (inputStream == null) {
			throw new FileNotFoundException();
		}
		InputStreamReader isr = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(isr);
		return br;
	}

	@Override
	public Shape[] getAvailableShapes() {
		return availableShapes;
	}

}
