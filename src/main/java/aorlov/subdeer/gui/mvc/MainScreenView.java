package aorlov.subdeer.gui.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Mouse
 * Date: 25.06.14
 * Time: 1:50
 * To change this template use File | Settings | File Templates.
 */
public class MainScreenView implements java.util.Observer  {


    JTextArea jtAreaOutput;
    JScrollPane jspPane;
    JMenuItem open, exit;

    MainScreenView() {
        System.out.println("View()");

        JFrame.setDefaultLookAndFeelDecorated(false);
        // Create and set up the window.
        JFrame frame = new JFrame("SubDeer - learn english through subtitles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(createJMenuBar());
        frame.setContentPane(createContentPane());
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public JMenuBar createJMenuBar() {
        JMenuBar mainMenuBar;
        JMenu fileMenu,helpMenu;    //menu1

        mainMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        mainMenuBar.add(fileMenu);
        helpMenu = new JMenu("Help");
        fileMenu.setMnemonic(KeyEvent.VK_H);
        mainMenuBar.add(helpMenu);
        // Creating the MenuItems
        //todo: ctrl+O
        open = new JMenuItem("Open",
                KeyEvent.VK_O);
        exit = new JMenuItem("Exit");
        // can be done either way for assigning shortcuts
        // menuItem.setMnemonic(KeyEvent.VK_T);
        // Accelerators, offer keyboard shortcuts to bypass navigating the menu
        // hierarchy.
        open.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
//        open.addActionListener(this);
        fileMenu.add(open);
        fileMenu.add(exit);
        return mainMenuBar;
    }
    public Container createContentPane() {
        // Create the content-pane-to-be.
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel top100Pane = new JPanel(new BorderLayout());
        JPanel allWordsPane = new JPanel(new BorderLayout());
        top100Pane.setLayout(new BorderLayout());// Can do it either way
        // to set layout
        top100Pane.setOpaque(true);
        // Create a scrolled text area.
        //todo: file below
        jtAreaOutput = new JTextArea(5, 30);
        jtAreaOutput.setEditable(false);
        //todo: refactor

//        jtAreaOutput.setText(guiHelper.getTextFile(""));
        jspPane = new JScrollPane(jtAreaOutput);
        // Add the text area to the content pane.
        top100Pane.add(jspPane, BorderLayout.CENTER);
        tabbedPane.addTab("Top 100", top100Pane);
        tabbedPane.add("all words", allWordsPane);
        tabbedPane.setSelectedIndex(0);

        return tabbedPane;
    }

    @Override
    public void update(Observable o, Object arg) {
        jtAreaOutput.setText("" + ((String)arg));
    }

    public void addController(ActionListener controller){
        System.out.println("View      : adding Controller");
        open.addActionListener(controller);	//need instance of Controller before can add it as a listener
    }

    public static class CloseListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        } //windowClosing()
    } //CloseListener
}
