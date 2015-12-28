import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

public class RandomAccessUTFTutor {

    private static final String FILES_TEST_PATH = "files/test.txt";
    File file = new File(FILES_TEST_PATH);
    /**
     * Write to the file FILES_TEST_PATH by path  2 lines UTF:
     * "Test line" and "test line 2"
     */
    public void randomAccessWriteUTF() {
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
            //randomAccessFile.seek(0);
            randomAccessFile.writeUTF("test line");
            randomAccessFile.writeUTF("test line 2");
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Jump to the second line of the UTF, using seek,
     * read and return its value
     * * @return
     */
    public String randomAccessReadUTF() {
        String result = null;
        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            randomAccessFile.seek(2);
            result = randomAccessFile.readUTF();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;

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

    @Test
    public void testRandomAccessUTF() throws UnsupportedEncodingException  {
        randomAccessWriteUTF();
        String s1 = null, s2 = null;
        try {
            RandomAccessFile f = new RandomAccessFile(FILES_TEST_PATH, "r");
            s1 = f.readUTF();
            s2 = f.readUTF();
            f.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertEquals("test line", s1);
        assertEquals("test line 2", s2);
        //String read = randomAccessReadUTF();
        //assertEquals("test line 2", read);
    }
}
