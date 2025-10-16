package lvl1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Execution execute = new Execution("src" + File.separator + "folderToList");
        execute.listFolderAlphabetically();
        execute.listFolderRecursively();
        String fileToRead = "src" + File.separator + "listOfFiles_16-10-2025.txt";
        ReadingFiles readingFiles = new ReadingFiles();
        readingFiles.readingTxtFile(fileToRead);
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
