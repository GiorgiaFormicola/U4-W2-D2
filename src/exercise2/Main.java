package exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static List<Integer> getRandomNumbersList(int N) {
        Random random = new Random();
        List<Integer> randomNumbersList = new ArrayList<>();
        if (N < 0) throw new RuntimeException("Impossible to provide a list of " + N + " numbers");
        else {
            for (int i = 0; i < N; i++) {
                randomNumbersList.add(random.nextInt(0, 100));
            }
            return randomNumbersList;
        }
    }

    private static <T> List<T> getListPlusItsInverse(List<T> list) {
        List<T> finalList = new ArrayList<>(list);
        finalList.addAll(list.reversed());
        return finalList;
    }

    private static <T> void getEvenOrUnevenListElements(List<T> list, boolean aBoolean) {
        List<T> evenElements = new ArrayList<>();
        List<T> unevenElements = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                evenElements.add(list.get(i));
            } else {
                unevenElements.add(list.get(i));
            }
        }
        if (aBoolean) {
            System.out.println("Even elements of the list: " + evenElements);
        } else {
            System.out.println("Uneven elements of the list: " + unevenElements);
        }
    }

    static void main(String[] args) {
        logger.info("Program started");
        logger.info("TEST: getRandomNumbersList method");
        try {
            System.out.println("List of 5 random numbers:" + getRandomNumbersList(5));
            System.out.println("List of 0 random numbers:" + getRandomNumbersList(0));
            System.out.println("List of -5 random number:" + getRandomNumbersList(-5));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        logger.info("TEST: getListPlusItsInverse method");
        List<Integer> testNumbersList = getRandomNumbersList(5);
        List<String> testStringsList = new ArrayList<>(List.of("hello", "world", "!"));
        System.out.println("Numbers list: " + testNumbersList);
        System.out.println("Numbers list modified: " + getListPlusItsInverse(testNumbersList));
        System.out.println("Strings list: " + testStringsList);
        System.out.println("Strings list modified: " + getListPlusItsInverse(testStringsList));

        logger.info("TEST: getEvenOrUnevenListElements method");
        System.out.println("Numbers list: " + testNumbersList);
        getEvenOrUnevenListElements(testNumbersList, true);
        getEvenOrUnevenListElements(testNumbersList, false);
        System.out.println("Strings list: " + testStringsList);
        getEvenOrUnevenListElements(testStringsList, true);
        getEvenOrUnevenListElements(testStringsList, false);

        logger.info("Program ended");
    }


}
