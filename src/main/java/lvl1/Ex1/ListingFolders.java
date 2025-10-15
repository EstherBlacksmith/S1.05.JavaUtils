package lvl1.Ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Objects;


public class ListingFolders {
    protected String folderPath;

    public ListingFolders(String folderPath) {
        this.folderPath = Objects.requireNonNull(folderPath);
    }

    protected void listRecursivelyFoldersAndFiles() throws IOException {
        String directoryPath = folderPath;
        folderPathValidation(directoryPath);

        Path directory = Paths.get(folderPath);

        File[] filesArray = directory.toFile().listFiles();
        Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println(  (attrs.isDirectory()?"D":"F")+ " " +file + " -- Modified: " +  attrs.lastModifiedTime());

                return FileVisitResult.CONTINUE;
            }
        });


    }

    protected void listSortedFiles() throws NullPointerException {

        try {
            String directoryPath = folderPath;
            folderPathValidation(directoryPath);

            Path directory = Paths.get(folderPath);

            File[] filesArray = directory.toFile().listFiles();
            Arrays.sort(filesArray);
            validatingDirectory(filesArray);

            System.out.println("Files are:");

            for (File file : filesArray) {
                System.out.println(file.getName());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void folderPathValidation(String directoryPath) throws NoSuchFileException, FileNotFoundException {
        Path path = Paths.get(directoryPath);
        if (Files.notExists(path)) {
            throw new NoSuchFileException("The indicated folder doesn't exist");
        }

        if (Files.isRegularFile(path)) {
            throw new FileNotFoundException("The indicated folder is a regular file");
        }
    }

    private void validatingDirectory(File[] filesArray) throws NullPointerException {
        if (filesArray == null) {
            throw new NullPointerException("The indicated folder is empty");
        } else if (filesArray.length == 0) {
            throw new NullPointerException("The indicated folder is empty");
        }

    }
}
