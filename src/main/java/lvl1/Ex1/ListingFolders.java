package lvl1.Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


public class ListingFolders {
    protected String folderPath;

    public ListingFolders(String folderPath) {
        this.folderPath = Objects.requireNonNull(folderPath);
    }

    protected void listSortedFiles() throws NullPointerException {

        try {
            Path folder = Paths.get(folderPath);

            folderpathValidation(folder);

            File[] filesArray = folder.toFile().listFiles();

            if( filesArray == null){
                throw new NullPointerException("The indicated folder is empty");
            }

            System.out.println("Files are:");
            for(File filetoSort : filesArray){
                System.out.println(filetoSort.getName());
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void folderpathValidation(Path folder) throws IOException {
        if (Files.notExists(folder)) {
            throw new NoSuchFileException("The indicated folder doesn't exist");
        }

        if(Files.isRegularFile(Paths.get(String.valueOf(folder)))){
            throw new FileNotFoundException("The indicated folder is a regular file");
        }

    }
}
