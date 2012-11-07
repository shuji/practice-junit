package ch09;

import java.io.File;
import java.io.IOException;

public class TemporaryFolderExample {

    public static void mkDefaultFiles(File folder) throws IOException {
        new File(folder, "UnitTest").createNewFile();
        new File(folder, "readme.txt").createNewFile();
    }

}
