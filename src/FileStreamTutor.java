import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class FileStreamTutor {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";
    File file = new File(FILES_TEST_PATH);
    /**
     * Writes a string TEST_LINE to the file FILES_TEST_PATH ,
     * converting the string into array of bytes.
     * For the writing, use the class FileOutputStream.
     */
    public void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(TEST_LINE.getBytes());
            fos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads a line from a file and returns it using FileInputStream.
     * @return
     */
    public String readFromFile() {
        byte[] byteArray = new byte[TEST_LINE.getBytes().length];
        String result = null;
        int counter = 0;
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read(byteArray);
            result = new String(byteArray);

        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void testFileStream() {
        writeToFile();
        String s = readFromFile();
        assertEquals(TEST_LINE, s);
    }

    @Before
    public void createFile() {
        File f1 = new File(FILES_TEST_PATH);
        try {
            f1.delete();
            f1.createNewFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
