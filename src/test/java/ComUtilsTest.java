import org.junit.Test;
import static org.junit.Assert.*;
import utils.ComUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ComUtilsTest {

    @Test
    public void example_test() {
        File file = new File("test");
        try {
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));
            comUtils.write_int32(2);
            int readedInt = comUtils.read_int32();

            assertEquals(2, readedInt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wr_int_test() {
        File file = new File("test");
        try {
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));
            comUtils.write_int32(4);
            int readedInt = comUtils.read_int32();

            assertEquals(4, readedInt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wr_string_test() {
        File file = new File("test");
        try {
            String value = "<3";
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));
            comUtils.write_string(value);
            String readedString = comUtils.read_string();

            assertEquals(value, readedString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wr_string_variable_test() {
        File file = new File("test");
        try {
            String value = "<3";
            int header_len = 4;
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));
            comUtils.write_string_variable(header_len,value);
            String readedString = comUtils.read_string_variable(header_len);

            assertEquals(value, readedString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void wr_char_test() {
        File file = new File("test");
        try {
            char value = 'A';
            file.createNewFile();
            ComUtils comUtils = new ComUtils(new FileInputStream(file), new FileOutputStream(file));
            comUtils.writeChar(value);
            char readedValue = comUtils.readChar();

            assertEquals(value, readedValue);
            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
