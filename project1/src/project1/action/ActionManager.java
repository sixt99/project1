package project1.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import project1.concept.Concept;
import project1.print.PrintingManager;

public class ActionManager {

	private static ActionManager instance = null;

	public static ActionManager getInstance() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}

	public void addWords(String filePath, Scanner sc) throws FileNotFoundException, UnsupportedEncodingException {

		boolean exit = false;

		while (!exit) {

			String production = sc.next();
			if (production.equals(PrintingManager.INPUT_EXIT)) {
				exit = true;
			} else {
				Concept concept = new Concept();
				concept.setNativeWord(production);
				concept.setTranslation(sc.next());
				PrintWriter writer = new PrintWriter(filePath, "UTF-8");
				writer.println(concept.toString());
				writer.close();
			}
		}
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
			String answer = listConcepts.get(randomNativeWord);

			System.out.println(randomNativeWord);
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
		// TODO
		// Read from yaml files.
		List<Concept> listConcepts = new ArrayList();
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
