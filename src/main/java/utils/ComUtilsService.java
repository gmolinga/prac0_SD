package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ComUtilsService {
    private ComUtils comUtils;
    private final int header_len = 4;
    private final String name = "Guillem MolinaGalera"; 
    private final int edat = 22;
    private final String comentari = "Com no realitzar aquesta pràctica: >-@^@-<";
    private final char character = 'A';
    
    public ComUtilsService(InputStream inputStream, OutputStream outputStream) throws IOException {
        comUtils = new ComUtils(inputStream, outputStream);
    }

    public void writeTest() throws IOException {
        //TODO: put your code here

        
        comUtils.write_string(this.name);
        comUtils.write_int32(this.edat);
        comUtils.write_string_variable(this.header_len, this.comentari);
        comUtils.writeChar(this.character);
    }

    public String readTest() throws IOException {
        String result = "";
        //TODO: put your code here
        
        String actual_name = comUtils.read_string();
        result += actual_name.equals(this.name);
        result += " - ";
        int actual_edat = comUtils.read_int32();
        result += actual_edat == this.edat;
        result += " - ";
        String actual_comentari = comUtils.read_string_variable(this.header_len);
        result += actual_comentari.equals(actual_comentari);
        result += " - ";
        char actual_character = comUtils.readChar();
        result += actual_character == this.character;
        
        return result;
    }



}
