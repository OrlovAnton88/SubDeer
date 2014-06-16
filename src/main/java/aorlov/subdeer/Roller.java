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

    public static void main (String [] args){

        String filename = "D:\\GitHub\\SubDeer\\src\\main\\resources\\test.sub";
        MyFileReader fileReader = new MyFileReaderImpl();
        String subs = fileReader.readFile(filename);

        Collection<Word> words = ParseEngine.getInstance().getListOfWords(subs);

        for(Word word: words){
            System.out.println(word.getWord());
        }
    }
}