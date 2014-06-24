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


    String filename = "D:\\GitHub\\SubDeer\\src\\main\\resources\\test.sub";

    public Roller() {

    }


    public Collection<Word> getListOfWords(String path) {
        if (path == null || path.length() == 0) {
            path = filename;
        }
        String subs = MyFileReader.getInstance().readFile(path);

        return ParseEngine.getInstance().getListOfWords(subs);
    }
}