package rps.ui;

import java.io.InputStream;

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

	public static InputStream getInputStream() {
		return System.in;
	}
}
