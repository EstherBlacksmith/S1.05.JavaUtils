package lvl1.Ex1;

import java.io.IOException;
import java.util.Objects;

public class Execution {
    static ListingFolders folderToList;
    String folderPath;

    public Execution(String folderPath) {
        this.folderPath = Objects.requireNonNull(folderPath);
        folderToList = new ListingFolders(Objects.requireNonNull(this.folderPath));
    }

    protected void listFolderAlphabetically() throws IOException {
        folderToList.listSortedFiles();
    }

    protected void listFolderRecursively() throws IOException {
        folderToList.listRecursivelyFoldersAndFiles();
    }
}
