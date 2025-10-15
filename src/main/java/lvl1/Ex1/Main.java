package lvl1.Ex1;

import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        Execution execute = new Execution();
        execute.ListFolderAlphabetically();

    }


    static String readString(String question) {
        String readedString = "";
        System.out.println(question);

        while (readedString == "") {
            if (inputScanner.hasNext()) {
                try {
                    readedString = inputScanner.nextLine();

                } catch (Exception e) {
                    System.out.println("Incorrect type.\n" + question);
                    inputScanner.nextLine();
                }
            }
        }
        return readedString;
    }
}
