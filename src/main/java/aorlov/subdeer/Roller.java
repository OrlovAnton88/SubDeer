package aorlov.subdeer;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 09.06.14
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class Roller {


    String filename = "G:\\my\\SubDeer\\src\\main\\resources\\Back.To.The.Future.sub";

    public Roller() {

    }


    public Collection<String> getListOfWords(String path) {
        if (path == null || path.length() == 0) {
            path = filename;
        }
        String subs = MyFileReader.getInstance().readFile(path);

        return ParseEngine.getInstance().getListOfWords(subs);
    }
}