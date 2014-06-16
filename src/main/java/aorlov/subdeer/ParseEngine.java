package aorlov.subdeer;

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

    public Collection<Word> getListOfWords(String subs) {
        StringBuffer regexSrt = new StringBuffer("\\s+|\\");
        for (int i = 0; i < symbols.length - 1; i++) {
            regexSrt = regexSrt.append(symbols[i]);
            regexSrt.append("|\\");
        }
        regexSrt.append(symbols[symbols.length - 1]);

        System.out.println(regexSrt.toString());
        String[] list = subs.split(regexSrt.toString());

        ArrayList<Word> toReturn = new ArrayList<Word>();
        for (int i = 0; i < list.length; i++) {
            Word word = new Word();
            String w = list[i];
            w = filter(w);
            if (w.length() != 0) {
                word.setWord(list[i]);
                toReturn.add(word);
            }
            i++;
        }
        return toReturn;

    }

    public String filter(String strIn) {

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

//        Set pronounce = getListOfSortOfWords();
//        if (pronounce.contains(strIn)) {
//            return "";
//        }

        return strIn;

    }

    public Set getListOfSortOfWords() {

        String pronFile = FileReaderHelper.getInstance().readFile("/Users/nika/IdeaProjects/SubDeer/res/pronsAtLeast3chars.txt");
        String[] pronouns = pronFile.split("\\n");
        Set pronounsSet = new HashSet();
        for (int i = 0; i < pronouns.length; i++) {
            pronounsSet.add(pronouns[i].trim());
        }
        return pronounsSet;
    }

    public static ParseEngine getInstance() {
        if (instance == null) {
            instance = new ParseEngine();
        }
        return instance;
    }
}
