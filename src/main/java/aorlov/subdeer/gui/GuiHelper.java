package aorlov.subdeer.gui;

import aorlov.subdeer.ParseEngine;
import aorlov.subdeer.Roller;
import aorlov.subdeer.Word;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 23.06.14
 * Time: 22:31
 * To change this template use File | Settings | File Templates.
 */
public class GuiHelper {

    public String getTextFile(String path) {

        Roller roller = new Roller();
        StringBuffer stringBuffer = new StringBuffer();
        Collection<Word> words = roller.getListOfWords(path);

        for (Word word : words) {
            stringBuffer.append(word.getWord());
            stringBuffer.append(System.lineSeparator());
        }

        return stringBuffer.toString();
    }
}
