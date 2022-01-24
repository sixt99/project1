package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



import concept.Concept;
import print.PrintingManager;

public class ActionManager {

	private static ActionManager instance = null;
	public static final String INPUT_ADD_WORDS = "Add";
	public static final String INPUT_SET_LANGUAGE = "Set language";

	public static ActionManager getInstance() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}

	public void addWords(PrintWriter writer, File file, Scanner sc) throws FileNotFoundException, UnsupportedEncodingException {

		boolean exit = false;

		while (!exit) {
			System.out.println("Adding a new word.");
			System.out.print("Native:");
			String production = sc.next();
			if (production.equals(PrintingManager.INPUT_EXIT)) {
				exit = true;
			} else {
				Concept concept = new Concept();
				concept.setNativeWord(production);
				System.out.print("Translation:");
				concept.setTranslation(sc.next());
				// If it is not already in the list, we add it
				if (!alreadyInList(concept, file)) {
					writer.append("\n");
					writer.append(concept.toString());
				}
			}
		}
	}

	private boolean alreadyInList(Concept concept, File file) {
		List<Concept> listConcepts = readWords(file);
		for (Concept c: listConcepts) {
			String cString = c.toString();
			String conceptString = concept.toString();
			if (conceptString.equalsIgnoreCase(cString)) {
				System.out.println("This word was already at the list!");
				return true;
			}
		}
		return false;
	}

	public void startRandomTesting(Scanner sc) {
		// TODO
		List<Concept> listConcepts = readWords(new File("project1/src/project1/file-demos/russian.txt"));
		Object[] arrayConcepts = listConcepts.toArray();

		boolean exit1 = false;
		boolean exit2 = false;
		Random generator = new Random();

		while (!exit1) {

			Concept randomConcept = (Concept) arrayConcepts[generator.nextInt(arrayConcepts.length)];
			String randomNative = randomConcept.getNativeWord();
			String answer = randomConcept.getTranslation();

			System.out.println(randomNative);
			while (!exit2) {
				String word = sc.nextLine();
				if (word.equals(answer)) {
					exit2 = true;
				} else if (PrintingManager.INPUT_EXIT.equals(word)) {
					exit2 = true;
					exit1 = true;
				} else {
					System.out.println(PrintingManager.WRONG_WORD);
				}
			}
			exit2 = false;
		}
	}



	private List<Concept> readWords(File file) {
		// TODO: Read from yaml files.
		List<Concept> listConcepts = new ArrayList<Concept>();
		try {
			Scanner sc = new Scanner(file);
			String[] word;
			while (sc.hasNextLine()) {
				word = sc.nextLine().split(": ");
				Concept concept = new Concept();
				concept.setNativeWord(word[0]);
				concept.setTranslation(word[1]);
				listConcepts.add(concept);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return listConcepts;
	}
}