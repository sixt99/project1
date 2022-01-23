package action;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import project1.print.PrintingManager;

public class ActionManager {

	private static ActionManager instance = null;

	public static ActionManager getInstance() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}

	public void startRandomTesting(Scanner sc) {
		Map<String, String> map = readWords(new File("words"));
		boolean exit1 = false;
		boolean exit2 = false;
		Random generator = new Random();

		while (!exit1) {
			Object[] nativeWords = map.keySet().toArray();
			String randomNativeWord = (String) nativeWords[generator.nextInt(nativeWords.length)];
			String answer = map.get(randomNativeWord);

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

	private Map<String, String> readWords(File file) {
		Map<String, String> map = new HashMap<>();
		try {
			Scanner sc = new Scanner(file);
			String[] word;
			while (sc.hasNextLine()) {
				word = sc.nextLine().split(":\s");
				map.put(word[0], word[1]);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		return map;
	}

}
