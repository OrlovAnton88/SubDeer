package aorlov.subdeer.gui;

import aorlov.subdeer.Roller;

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
        Collection<String> words = roller.getListOfWords(path);

        for (String word : words) {
            stringBuffer.append(word);
            stringBuffer.append(System.lineSeparator());
        }

        return stringBuffer.toString();
    }
}
