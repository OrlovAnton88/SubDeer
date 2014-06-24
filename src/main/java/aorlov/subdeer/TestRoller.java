package aorlov.subdeer;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 23.06.14
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public class TestRoller {

    public static void main (String [] args){
        Roller roll= new Roller();
        Collection<Word> words = roll.getListOfWords("");

        for(Word word: words){
            System.out.println(word.getWord());
        }
    }
}

