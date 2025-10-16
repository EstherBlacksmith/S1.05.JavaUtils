package lvl1.Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFiles {
    public ReadingFiles() {}

    public  void readingTxtFile(String pathFile) {
        File myObj = new File(pathFile);

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. " + e.getMessage() );
        }
    }

}
