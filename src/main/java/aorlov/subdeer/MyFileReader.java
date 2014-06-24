package aorlov.subdeer;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 09.06.14
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public class MyFileReader {

    private static MyFileReader instance;

    private MyFileReader() {
    }

    public String readFile(String filename) {
        String content = null;
        File file = new File(filename); //for ex foo.txt
        try {
            java.io.FileReader reader = new java.io.FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    public static MyFileReader getInstance() {
        if (instance == null) {
            instance = new MyFileReader();
        }
        return instance;
    }


}
