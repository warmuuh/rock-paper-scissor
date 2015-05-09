package rps.ui;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * utility class to encapsulate syso access
 * 
 * @author pm
 *
 */
public final class ConsoleIO {
	private ConsoleIO() {
	}

	public static void displayMessage(String string) {
		System.out.println(string);
	}

	@SuppressWarnings("resource")
	private static Optional<Integer> tryReadInteger() {
		Scanner scanner = new Scanner(System.in);
		try {
			int input = scanner.nextInt();
			return Optional.of(input);
		} catch (InputMismatchException e) {
			return Optional.empty();
		}
	}

	/**
	 * reads an integer from system.in that needs to be between min and max.
	 * retries with displaying the errormessage on invalid input
	 */
	public static Integer getValidChoice(int min, int max, String errorMessage) {
		Optional<Integer> input;
		do {
			input = tryReadInteger();
			input = input.filter(in -> in >= min && in <= max);
			if (!input.isPresent()) {
				displayMessage(errorMessage);
			}
		} while (!input.isPresent());
		return input.get();
	}

}
