package aorlov.subdeer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
        return readFile(file);
    }

    public String readFile(File file) {
        String content = null;
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

    public Collection<File> getListOfFilters(String directoryPath){
        Collection<File> filters = new ArrayList<>();
        File folder =   new File(directoryPath);
        File[] files = folder.listFiles();
        for(File file: files){
            if(file.isFile()){
                String filename = file.getName();
                if(filename.contains(".filter")){
                 filters.add(file);
                }
            }
        }
        return filters;
    }


    public static MyFileReader getInstance() {
        if (instance == null) {
            instance = new MyFileReader();
        }
        return instance;
    }


}
