package exercise1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords;
        logger.info("Program started");
        while (true) {
            System.out.println("Enter the number of words you'd like to add:");
            try {
                numberOfWords = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("You must type an integer number, try again!");
                logger.error("ERROR: {}", e.getMessage());
            }
        }

        if (numberOfWords != 0) {
            System.out.println("Now enter " + numberOfWords + " words of your choice: ");
            Set<String> uniqueWordsSet = new HashSet<>();
            Set<String> duplicatedWordsSet = new HashSet<>();

            for (int i = 0; i < numberOfWords; i++) {
                String wordToAdd = scanner.nextLine().toLowerCase();
                if (wordToAdd.isBlank() || wordToAdd.contains(" ")) {
                    System.out.println("You must enter a word, try again!");
                    i--;
                } else {
                    if (!uniqueWordsSet.add(wordToAdd)) {
                        duplicatedWordsSet.add(wordToAdd);
                    }
                }
            }
            
            System.out.println(uniqueWordsSet.size() + (uniqueWordsSet.size() == 1 ? " different word has been entered:" : " different words have been entered:"));
            for (String currentWord : uniqueWordsSet) System.out.println(currentWord);

            if (duplicatedWordsSet.isEmpty()) {
                System.out.println("No words have been entered more than once.");
            } else {
                System.out.println(duplicatedWordsSet.size() + (duplicatedWordsSet.size() == 1 ? " word has been duplicated:" : " different words have been duplicated:"));
                for (String currentWord : duplicatedWordsSet) System.out.println(currentWord);
            }
        } else {
            System.out.println("You chose not to enter any words, bye bye!");
        }
        logger.info("Program ended");
    }
}

