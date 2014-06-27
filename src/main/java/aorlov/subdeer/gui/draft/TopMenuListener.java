package aorlov.subdeer.gui.draft;

import aorlov.subdeer.MyFileReader;
import aorlov.subdeer.ParseEngine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by aorlov on 6/25/14.
 */
public class TopMenuListener implements ActionListener {
    JFileChooser fc = new JFileChooser();
    MainGuiClass mainGuiClass;

   public TopMenuListener(MainGuiClass mainGuiClass){
           this.mainGuiClass = mainGuiClass;
   }
    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Open".equals(e.getActionCommand())) {
            int returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    System.out.println("Opening: " + file.getName());
                    String source = MyFileReader.getInstance().readFile(file);
//                    Collection<String> listOfWordsInString =ParseEngine.getInstance().getListOfWordsInString(source);
//                    StringBuffer result = new StringBuffer();
//                    for(String word: listOfWordsInString){
//                         result.append(word);
//                        result.append(System.lineSeparator());
//                    }
//                    System.out.println(result.toString());
//                    mainGuiClass.updateTextField(result.toString());


                    mainGuiClass.updateTable(ParseEngine.getInstance().getWordsArrayToFillTable(source));
                }
            }

        }

    }
}
