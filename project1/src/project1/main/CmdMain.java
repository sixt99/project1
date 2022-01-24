package project1.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import project1.action.ActionManager;
import project1.print.PrintingManager;



public class CmdMain {
	
	public static final String[] SUPPORTED_LANGUAGES = {"catalan", "spanish", "english", "german", "russian", "italian"};
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		PrintingManager.getInstance().printWelcome();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		// Set catalan as default language, but this can be changed in `INPUT_SET_LANGUAGE` option
		String language = "catalan";

		while (!exit) {
			PrintingManager.getInstance().printMenu();
			String action = sc.nextLine();

			switch (action) {
			case PrintingManager.INPUT_SEE_INSTRUCTIONS:
				PrintingManager.getInstance().printInstructions();
				break;

			case ActionManager.INPUT_SET_LANGUAGE:
				language = sc.next();
				if (!Arrays.stream(SUPPORTED_LANGUAGES).anyMatch(language::equals)) {
					System.out.println("This language is not supported");
					break;
				}
				break;

			case ActionManager.INPUT_ADD_WORDS:
				// Ask for the translations language and check wether it is supported
				System.out.println("Choose the language of translations");
				String translation = sc.next();
				if (!Arrays.stream(SUPPORTED_LANGUAGES).anyMatch(translation::equals)) {
					System.out.println("This language is not supported");
					break;
				}
				// Manually create a string with the file path
				String filePath = "project1/src/project1/words-files/" + language + "/" + translation;
				// Open (or create if it does not exist) the file with the language and translations
				File file = new File(filePath);
				PrintWriter out = null;
				if ( file.exists() && !file.isDirectory() ) {
					// If it already exists, we don't want to create a new one ot override it
					out = new PrintWriter(new FileOutputStream(new File(filePath), true));
				} else {
					out = new PrintWriter(filePath);
				}
				// Do the adding words and close the writting file
				ActionManager.getInstance().addWords(out, file, sc);
				out.close();
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