package aorlov.subdeer.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
* Created with IntelliJ IDEA.
* User: Mouse
* Date: 23.06.14
* Time: 22:04
* To change this template use File | Settings | File Templates.
*/
public class MainGuiClass implements ActionListener{
    GuiHelper guiHelper;
    public MainGuiClass(){
                         guiHelper = new GuiHelper();
    }

    JTextArea jtAreaOutput;
    JScrollPane jspPane;

    public JMenuBar createJMenuBar() {
        JMenuBar mainMenuBar;
        JMenu fileMenu,helpMenu;    //menu1
        JMenuItem open, exit;
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
        open.addActionListener(this);
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

        jtAreaOutput.setText(guiHelper.getTextFile(""));
        jspPane = new JScrollPane(jtAreaOutput);
        // Add the text area to the content pane.
        top100Pane.add(jspPane, BorderLayout.CENTER);
        tabbedPane.addTab("Top 100", top100Pane);
        tabbedPane.add("all words", allWordsPane);
        tabbedPane.setSelectedIndex(0);

        return tabbedPane;
    }

    private static void createGUI() {
        JFrame.setDefaultLookAndFeelDecorated(false);
        // Create and set up the window.
        JFrame frame = new JFrame("SubDeer - learn english through subtitles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainGuiClass app = new MainGuiClass();
        frame.setJMenuBar(app.createJMenuBar());
        frame.setContentPane(app.createContentPane());
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                createGUI();
            }
        });


    }

}
