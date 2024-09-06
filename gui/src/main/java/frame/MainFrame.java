package frame;

import constants.NumberConstant;
import constants.StringConstant;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        super(StringConstant.APP_NAME);

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
