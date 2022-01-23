package project1.print;

public class PrintingManager {

	public static final String GOODBYE_MESSAGE = "Hope you had fun!";
	public static final String INPUT_EXIT = "Exit";
	public static final String INPUT_SEE_CONTACT = "See contact";
	public static final String INPUT_SEE_INSTRUCTIONS = "See instructions";
	public static final String INPUT_START = "Start";
	public static final String INVALID_ACTION = "Hey, that makes no sense.";
	public static final String WRONG_WORD = "Hey, wrong answer.";

	private static PrintingManager instance = null;

	public static PrintingManager getInstance() {
		if (instance == null) {
			instance = new PrintingManager();
		}
		return instance;
	}

	public void printContact() {
		System.out.println("Program designed by Sixte Oriol Llenas Segura, student of Mathematics in Barcelona.");
		System.out.println("E-Mail: sixte99@gmail.com");
	}

	public void printInstructions() {

		System.out.println(
				"There is a file called 'words'. Write in that file the list of words you need to learn and their translation, like in the example:");
		System.out.println("\tRiver: el río");
		System.out.println("\tBook: el libro");
		System.out.println("\tApple: la manzana");
		System.out.println(
				"Also, this program supports other symbols! So you can start to learn all those languages you said you were definitely going to learn.");
	}

	public void printMenu() {
		System.out.println("What do you want to do?");
		System.out.println("\t(1). " + INPUT_START);
		System.out.println("\t(2). " + INPUT_SEE_INSTRUCTIONS);
		System.out.println("\t(3). " + INPUT_SEE_CONTACT);
		System.out.println("\t(4). " + INPUT_EXIT);
	}

	public void printWelcome() {
		System.out.println("Hello, welcome!");
		System.out.println(
				"This program helps you learn vocabulary. You choose the words you need to learn, write their translation down and we do the rest.");
	}

}
