package aorlov.subdeer;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 09.06.14
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public class FileReaderHelper implements MyFileReader {

    private static FileReaderHelper instance;
    MyFileReader fileReader;

    private FileReaderHelper() {
        fileReader = new MyFileReaderImpl();
    }

    @Override
    public String readFile(String filename) {
        return fileReader.readFile(filename);
    }


    public static FileReaderHelper getInstance() {
        if (instance == null) {
            instance = new FileReaderHelper();
        }
        return instance;
    }


}
