package frame;

import constants.NumberConstant;
import constants.StringConstant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    public MainFrame() {
        super(StringConstant.APP_NAME);
        constructFrame();
        setJMenuBar(constructMenuBar());

    }

    //Method for menu bar options
    private JMenuBar constructMenuBar(){
        // Creates the menu bar
        JMenuBar menuBar = new JMenuBar();
        //Creates file option
        JMenu fileMenu = new JMenu(StringConstant.MENU_FILE);
        //Creates items for file option
        JMenuItem open = new JMenuItem(StringConstant.ITEM_OPEN);
        JMenuItem exit = new JMenuItem(StringConstant.ITEM_EXIT);
        //Add open and exit item to file
        fileMenu.add(open);
        fileMenu.add(exit);

        //Creates edit option
        JMenu editMenu = new JMenu(StringConstant.MENU_EDIT);
        //Creates add and remove student option
        JMenuItem addStudents = new JMenuItem(StringConstant.ITEM_ADD);
        JMenuItem removeStudents = new JMenuItem(StringConstant.ITEM_REMOVE);
        //Add options to edit menu
        editMenu.add(addStudents);
        editMenu.add(removeStudents);

        //Adds file and edit to menu
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //Listener for exit item
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,StringConstant.EXIT_MESSAGE,
                        StringConstant.EXIT_POPUP_TITLE,
                        JOptionPane.YES_NO_OPTION);

                if (action == JOptionPane.YES_OPTION) {
                    System.gc();
                    System.exit(0);
                }
            }
        });

        return menuBar;
    }

    //Method which handles frame properties.
    private void constructFrame(){
        //frame size
        setSize(NumberConstant.FRAME_WIDTH, NumberConstant.FRAME_HEIGHT);
        //default close operation
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Opens the frame in the center of the window
        setLocationRelativeTo(null);
        //frame visibility
        setVisible(true);
    }
}
