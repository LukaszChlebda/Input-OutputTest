import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class FileTutor {
    String separator = System.getProperty("file.separator");
    File dir = new File("test");
    File file = new File("test"+separator+"test.txt");
    /**
     * The method must create a folder and file test.txt inside it
     * - the file test/test.txt
     * Also, output in the full path to the log file you created
     */
    public void createFile() {

        try {
            dir.mkdir();
            file.createNewFile();
        }catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * This method should remove the folder and test file test / test.txt
     */
    public void deleteFile() {
        file.delete();
        dir.delete();
    }


    @Test
    public void testCreateFile() {
        createFile();
        File f = new File("test/test.txt");
        assertTrue(f.exists());
    }

    @Test
    public void testDeleteFile() {
        deleteFile();
        File f = new File("test/test.txt");
        assertFalse(f.exists());
        assertFalse(new File("test").exists());
    }


}
