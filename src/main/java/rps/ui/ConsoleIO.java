package rps.ui;

import java.io.InputStream;
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

	public static Optional<Integer> tryReadInteger() {
		Scanner scanner = new Scanner(ConsoleIO.getInputStream());
		try {
			int input = scanner.nextInt();
			return Optional.of(input);
		} catch (InputMismatchException e) {
			return Optional.empty();
		}
	}

	public static InputStream getInputStream() {
		return System.in;
	}
}
