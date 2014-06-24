package aorlov.subdeer.gui.mvc;

import aorlov.subdeer.Word;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 25.06.14
 * Time: 1:42
 * To change this template use File | Settings | File Templates.
 */
public class SubListModel extends java.util.Observable {

    private Collection <String> words;

    public Collection<String> getWords() {
        return words;
    }

    public void setWords(Collection<String> words) {
        this.words = words;
    }

    public boolean removeWord(){
        throw new UnsupportedOperationException("Not impemented yet");
    }




}
