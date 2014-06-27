package aorlov.subdeer;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 09.06.14
 * Time: 23:54
 * To change this template use File | Settings | File Templates.
 */
public class ParseEngine {

    private static ParseEngine instance = null;

    private char[] symbols = new char[]{'.', ',', ';', ':', '{', '}', '[', ']', '|', '!', '?'};

    public Collection<String> getListOfWords(String subs) {
        StringBuffer regexSrt = new StringBuffer("\\s+|\\");
        for (int i = 0; i < symbols.length - 1; i++) {
            regexSrt = regexSrt.append(symbols[i]);
            regexSrt.append("|\\");
        }
        regexSrt.append(symbols[symbols.length - 1]);

        System.out.println(regexSrt.toString());
        String[] list = subs.split(regexSrt.toString());

        ArrayList<String> toReturn = new ArrayList<String>();
        for (int i = 0; i < list.length; i++) {
            String w = list[i];
            w = filter(w);
            if (w.length() != 0) {
                toReturn.add(list[i]);
            }
            i++;
        }
        return toReturn;
    }

    public Set<String> getSetOfWords(Collection <String> listOfWords){
        Set <String> setOfWrods = new HashSet<>();
        for(String word: listOfWords){
            setOfWrods.add(word);
        }
         return setOfWrods;
    }

//    public Collection<String> getListOfWordsInString(String subs) {
//        Collection<Word> words =  getListOfWords(subs);
//        Collection<String> toReturn = new ArrayList<>();
//        for(Word word : words){
//            toReturn.add(word.getWord());
//        }
//        return toReturn;
//    }
//
    public Collection<String[]> getWordsArrayToFillTable(String subs) {
        Collection<String> words =  getSetOfWords(getListOfWords(subs));
        Collection<String[]> toReturn = new ArrayList<String[]>();
        int counter =0;
        String[] stringsArray = new String[6];
        for(String word : words){
            stringsArray[counter] = word;
            if(counter ==5){
                toReturn.add(stringsArray);
                stringsArray =new String[6];
                counter=0;

            }else{
                counter++;
            }
        }
        return toReturn;
    }

    public Collection<Word> getTop100Words() {
        return null;
    }


    private String filter(String strIn) {

        if (strIn.length() < 3) {
            return "";
        }

        Pattern pattern = Pattern.compile(".*[a-zA-Z]");
        Matcher matcher = pattern.matcher(strIn);
        if (matcher.find()) {
            strIn = strIn.substring(matcher.start(), strIn.length());

        } else {
            return "";
        }

        Set sortOutWords = getListOfSortOfWords();
        if (sortOutWords.contains(strIn)) {
            return "";
        }

        return strIn;

    }

    public Set getListOfSortOfWords() {
        Set distinctWords = new HashSet();
        Collection<File> filters = MyFileReader.getInstance().getListOfFilters("G:\\my\\SubDeer\\src\\main\\resources");

        for (File filter : filters) {
            String data = MyFileReader.getInstance().readFile(filter);
            String[] words = data.split("\\n");
            for (int i = 0; i < words.length; i++) {
                distinctWords.add(words[i].trim());
            }
        }
        return distinctWords;
    }

    public static ParseEngine getInstance() {
        if (instance == null) {
            instance = new ParseEngine();
        }
        return instance;
    }
}
