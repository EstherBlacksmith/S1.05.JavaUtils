package JavaUtilsExercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManipulatingFiles {
    public ManipulatingFiles() {
    }

    private Path gettingRelativerPath(String pathFile) {
        pathFile = pathFile.replace(File.separator, "\\");
        Path actualDirectoryUser = Paths.get(System.getProperty("user.dir"));
        Path absolutPath = Paths.get(pathFile);
        System.out.println(actualDirectoryUser);
        System.out.println(pathFile);
        try {
            return actualDirectoryUser.relativize(absolutPath);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return actualDirectoryUser;
    }

    protected void readingTxtFile(String pathFile) {

        File myObj = new File(gettingRelativerPath(pathFile).toUri());

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
            if (!Files.exists(Path.of(path))) {
                throw new RuntimeException("The file doesn't even exists");
            }
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
