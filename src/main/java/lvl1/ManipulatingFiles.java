package lvl1;

import java.io.*;
import java.util.Scanner;

public class ManipulatingFiles {
    public ManipulatingFiles() {
    }

    protected void readingTxtFile(String pathFile) {
        File myObj = new File(pathFile);

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. " + e.getMessage());
        }
    }

    protected void serializeObject(String path, ObjectToSerialize objectToSerialize) {
        try {
            FileOutputStream fileOutputS = new FileOutputStream(path);

            ObjectOutputStream ObjectOutputS = new ObjectOutputStream(fileOutputS);

            ObjectOutputS.writeObject(objectToSerialize);

            ObjectOutputS.close();
            fileOutputS.close();

            System.out.println("Serialized data is saved in " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    protected void deSerializeObject(String path) {
        try {

            FileInputStream fileInputS = new FileInputStream(path);

            ObjectInputStream ObjectInputS = new ObjectInputStream(fileInputS);
            ObjectToSerialize objectToDeSerialize = null;
            objectToDeSerialize = (ObjectToSerialize) ObjectInputS.readObject();

            ObjectInputS.close();
            fileInputS.close();

            System.out.println("Name = " + objectToDeSerialize.getName());
            System.out.println("Class Name = " + objectToDeSerialize.getQuantity());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

            throw new RuntimeException(e);
        }
    }

}
