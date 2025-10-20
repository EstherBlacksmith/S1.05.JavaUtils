package JavaUtilsExercises_lvl_1_2;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


public class ListingFolders {
    public ListingFolders() {}

    protected void listRecursivelyFoldersAndFiles(String folderPathToLIst, String pathToGetListingFiles) throws IOException {
        String directoryPath = folderPathToLIst;
        folderPathValidation(directoryPath);
        Path directory = Paths.get(folderPathToLIst);

        ArrayList<String> filesNamesArray = new ArrayList<>();
        Files.walkFileTree(directory, new SimpleFileVisitor<>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                String s = attrs.isDirectory() ? "D" : "F" + " " + file + " -- Modified: " + attrs.lastModifiedTime();
                filesNamesArray.add(s);
                return FileVisitResult.CONTINUE;
            }
        });
        listingFilesIntoTxtFile(filesNamesArray, pathToGetListingFiles);
    }

    protected void listSortedFiles(String folderPath, String pathToGetListingFiles) throws NullPointerException {

        try {
            String directoryPath = folderPath;
            folderPathValidation(directoryPath);

            Path directory = Paths.get(folderPath);

            File[] filesArray = directory.toFile().listFiles();
            Arrays.sort(filesArray);
            validatingDirectory(filesArray);

            listingFilesIntoTxtFile(filesArray, pathToGetListingFiles);
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

    private String calendarForFileTittle() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        return format1.format(calendar.getTime());
    }

    private Path preparePathForWriting(String listingType) {
        Path basePath = Paths.get("");
        return basePath.resolve(listingType + "_" + calendarForFileTittle() + ".txt");
    }

    private void listingFilesIntoTxtFile(File[] filesArray, String pathToGetListingFiles) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(preparePathForWriting(pathToGetListingFiles + File.separator + "OnlyFiles").toFile(), false));
            for (File files : filesArray) {
                bufferedWriter.write(files.getName() + System.lineSeparator());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private void listingFilesIntoTxtFile(ArrayList<String> filesNamesArray, String pathToGetListingFiles) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(preparePathForWriting(pathToGetListingFiles + File.separator + "Recursively").toFile(), false));
            bufferedWriter.write("Type  Name    Data" + System.lineSeparator());
            for (String filesName : filesNamesArray) {
                bufferedWriter.write(filesName + System.lineSeparator());
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
