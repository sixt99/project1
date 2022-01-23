package project1.main;

import java.util.Scanner;

import project1.action.ActionManager;
import project1.print.PrintingManager;

public class CmdMain {

	public static void main(String[] args) {

		PrintingManager.getInstance().printWelcome();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			PrintingManager.getInstance().printMenu();
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

			case PrintingManager.INPUT_SEE_CONTACT:
				PrintingManager.getInstance().printContact();
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