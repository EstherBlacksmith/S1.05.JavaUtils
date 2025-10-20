package JavaUtilsExercises.lvl1;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Execution {
    static String folderPath;

    public Execution(String folderPath) {
        Execution.folderPath = Objects.requireNonNull(folderPath);
    }

    private static String readString(String question, Scanner inputScanner) {
        String readedString = "";
        System.out.println(question);
        while (readedString.isEmpty()) {
            if (inputScanner.hasNext()) {
                readedString = inputScanner.nextLine().trim();
            }
        }
        return readedString;
    }

    private static int readInt(String question, Scanner inputScanner) {
        int readedInt;
        System.out.println(question);

        while (true) {
            try {
                readedInt = inputScanner.nextInt();
                if (readedInt < 0) {
                    throw new InputMismatchException("Must be a positive value.\n" + question);
                }
                return readedInt;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect type.\n" + question);
                inputScanner.nextLine();
            }
        }
    }

    private static void option1() throws IOException {
        ListingFolders listingFolders = new ListingFolders();
        listingFolders.listSortedFiles(folderPath);
    }

    private static void option2() throws IOException {
        ListingFolders listingFolders = new ListingFolders();
        listingFolders.listRecursivelyFoldersAndFiles(folderPath);
    }

    private static void option3() {
        Scanner scanner = new Scanner(System.in);
        String fileToRead = readString("Indicate de complete path and name of the file to read", scanner);
        ManipulatingFiles manipulatingFiles = new ManipulatingFiles();
        manipulatingFiles.readingTxtFile(fileToRead);
    }

    private static void option4() {
        ManipulatingFiles manipulatingFiles = new ManipulatingFiles();
        ObjectToSerialize object1 = new ObjectToSerialize("One", 1);
        manipulatingFiles.serializeObject("src" + File.separator + "objectSerialized.ser", object1);
    }

    private static void option5() {
        ManipulatingFiles manipulatingFiles = new ManipulatingFiles();
        manipulatingFiles.deSerializeObject("src" + File.separator + "objectSerialized.ser");
    }

    protected void menu() throws IOException {
        Scanner scannerOption = new Scanner(System.in);

        String question = "Indicates one of the options:\n" +
                "1. List a folder alphabetically (results in a file)\n" +
                "2. List a folder recursively (results in a file)\n" +
                "3. Read a txt file\n" +
                "4. Serialize a Java Object\n" +
                "5. DeSerialize the previous object\n" +
                "0. Exit";
        int option = 0;

        while (true) {
            option = readInt(question, scannerOption);
            switch (option) {
                case 1 -> {
                    option1();
                }
                case 2 -> {
                    option2();
                }
                case 3 -> {
                    option3();
                }
                case 4 -> {
                    option4();
                }
                case 5 -> {
                    option5();
                }
                case 0 -> {
                    return;
                }
                default -> {
                    System.out.println("Unexpected value: " + option);
                }
            }
        }
    }
}
