import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class DataStreamTutor extends Tutor {
    private static final String FILES_TEST_PATH = "files/test.txt";
    private static final String TEST_LINE = "test line";

    /**
     * Writes a string TEST_LINE to the file FILES_TEST_PATH, using
     * method writeUTF of class DataOutputStream.
     * Also use BufferedOutputStream for buffering.
     * Then close the stream.
     */
    public void writeToFile() throws IOException {
        try(
            FileOutputStream fis = new FileOutputStream(FILES_TEST_PATH);
            BufferedOutputStream bos = new BufferedOutputStream(fis);
            DataOutputStream dos = new DataOutputStream(bos))
        {
            dos.writeUTF(TEST_LINE);
        } catch (NullPointerException f) {
            f.printStackTrace();
        }catch
        (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Reads a line from a file using the method readUTF and returns it.
     * @return
     */
    public String readFromFile() {
        String result = null;

        try {
            FileInputStream fis = new FileInputStream(FILES_TEST_PATH);
            DataInputStream dis = new DataInputStream(fis);
            result = dis.readUTF();
            dis.close();
            fis.close();
        }catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    @Test
    public void testStream() throws IOException {
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
