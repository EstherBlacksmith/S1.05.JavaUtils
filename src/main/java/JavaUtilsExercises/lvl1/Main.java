package JavaUtilsExercises.lvl1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String path = "src" + File.separator + "folderToList";

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        Execution execute = new Execution(path);

        execute.menu();

        inputScanner.close();
    }
}