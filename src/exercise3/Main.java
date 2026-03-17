package exercise3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    private static HashMap<String, Integer> phoneBook = new HashMap<>();

    private static void addContact(String name, Integer phoneNumber) {
        if (name.isBlank())
            throw new RuntimeException("To add a contact you must provide a valid name");
        if (phoneBook.containsKey(name))
            throw new RuntimeException("Contact already present in the phone book");
        else phoneBook.put(name, phoneNumber);
    }

    private static void removeContact(String name) {
        if (name.isBlank()) throw new RuntimeException("To remove a contact you must provide a valid name");
        if (!phoneBook.containsKey(name)) throw new RuntimeException("Contact not available in the phone book");
        else phoneBook.remove(name);
    }


    private static String searchByPhoneNumber(Integer phoneNumber) {
        String person = "";
        for (String name : phoneBook.keySet()) {
            if (phoneBook.get(name).equals(phoneNumber)) person = name;
        }
        if (person.isEmpty()) throw new RuntimeException("Contact not found");
        else return person;
    }

    private static Integer searchByName(String name) {
        if (name.isBlank()) throw new RuntimeException("To remove a contact you must provide a valid name");
        if (phoneBook.get(name) != null) return phoneBook.get(name);
        else throw new RuntimeException("The provided phone number isn't linked to any contact in the phone book");
    }

    private static void printPhoneBook() {
        if (!phoneBook.isEmpty()) {
            for (String contact : phoneBook.keySet()) System.out.println(contact + ": " + phoneBook.get(contact));
        } else {
            System.out.println("No contacts saved in the phone book");
        }
    }


    public static void main(String[] args) {
        logger.info("Program started");
        logger.info("PHONE BOOK before starting tests:");
        printPhoneBook();

        logger.info("TEST 1: addContact method");
        try {
            addContact("Giorgia", 333);
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            addContact("Giorgia", 666);
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            addContact("", 777);
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            addContact(" ", 888);
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            addContact("Marco", 555);
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            addContact("Giulia", 444);
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        logger.info("PHONE BOOK after TEST 1:");
        printPhoneBook();

        logger.info("TEST: removeContact method");
        try {
            removeContact("Giorgia");
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            removeContact("Giorgia");
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            removeContact("");
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            removeContact(" ");
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        logger.info("PHONE BOOK after TEST 2:");
        printPhoneBook();

        logger.info("TEST 3: searchByPhoneNumber method");
        try {
            System.out.println("Person with phone number 555: " + searchByPhoneNumber(555));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("Person with phone number 000: " + searchByPhoneNumber(000));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        logger.info("TEST 3: searchByName method");

        try {
            System.out.println("Marco phone number: " + searchByName("Marco"));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("Empty string phone number: " + searchByName(""));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("Blank string phone number: " + searchByName(""));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        try {
            System.out.println("Blank string phone number: " + searchByName("Giorgia"));
        } catch (RuntimeException e) {
            logger.error("ERROR: " + e.getMessage());
        }

        logger.info("TEST 4: printPhoneBook method");
        printPhoneBook();


        logger.info("Program ended");
    }
}
