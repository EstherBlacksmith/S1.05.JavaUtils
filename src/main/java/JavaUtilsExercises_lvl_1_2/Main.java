package JavaUtilsExercises_lvl_1_2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner inputScanner = new Scanner(System.in);
        Execution execute = new Execution();

        execute.getProperties();

        execute.menu();

        inputScanner.close();
    }
}