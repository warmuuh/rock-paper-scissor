package rps;

import rps.ui.ConsoleUi;

public class Application {

	public static void main(String[] args) {

		ConsoleUi ui = new ConsoleUi();
		ui.initialize();
		ui.start();
	}

}
