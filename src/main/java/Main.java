
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import utils.ComUtilsService;

public class Main {

    public static void main(String[] args) {
        //TODO: Put your code here
        File file = new File("main_file");
          try {
              file.createNewFile();
              ComUtilsService comUtilsService = new ComUtilsService(new FileInputStream(file), new FileOutputStream(file));
              comUtilsService.writeTest();
              System.out.println(comUtilsService.readTest());
            }
            catch(IOException e)
            {
                System.out.println("Error Found during Operation:" + e.getMessage());
                e.printStackTrace();
            }
    }

}