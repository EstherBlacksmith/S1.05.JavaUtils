package lvl1.Ex1;

import java.io.File;

public class Execution {

    protected static void ListFolderAlphabetically(){
        String folderPath  = "src" + File.separator + "folderToList";
        ListingFolders folderToList = new ListingFolders(folderPath);

        folderToList.listSortedFiles();
    }
}
