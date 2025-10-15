package lvl1.Ex1;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Execution {
    String folderPath;
    static ListingFolders folderToList;

    public Execution(String folderPath) {
        this.folderPath = Objects.requireNonNull(folderPath);
        this.folderToList = new ListingFolders( Objects.requireNonNull(this.folderPath));
    }

    protected static void listFolderAlphabetically() throws IOException {
        folderToList.listSortedFiles();
    }

    protected static void listFolderRecursively() throws IOException {
        folderToList.listRecursivelyFoldersAndFiles();
    }
}
