package project1.CmdMain;

import java.util.Scanner;

import action.ActionManager;
import project1.print.PrintingManager;

public class Main {

	public static void main(String[] args) {
		PrintingManager.getInstance().printWelcome();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			String action = sc.nextLine();

			switch (action) {
			case PrintingManager.INPUT_SEE_INSTRUCTIONS:
				PrintingManager.getInstance().printInstructions();
				break;

			case PrintingManager.INPUT_START:
				System.out.println("Let's go! Enter '" + PrintingManager.INPUT_EXIT + "' when you want to finish.");
				ActionManager.getInstance().startRandomTesting(sc);
				exit = true;
				break;

			case PrintingManager.INPUT_EXIT:
				exit = true;
				break;

			default:
				System.out.println(PrintingManager.INVALID_ACTION);
			}
		}

		System.out.println(PrintingManager.GOODBYE_MESSAGE);
	}

}