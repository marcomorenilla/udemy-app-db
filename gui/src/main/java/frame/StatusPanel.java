package frame;


import constants.StringConstant;


import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;


public class StatusPanel extends JPanel {
    JLabel statusLabel;
    JLabel timeLabel;
    Timer timer;

    public StatusPanel() {
        initializeVariables();
        initializeLayout();
        startTimer();
    }

    private void initializeVariables() {
        statusLabel = new JLabel();
        timeLabel = new JLabel();
        timer = new Timer(timeLabel);
        statusLabel.setText(StringConstant.STATUS_TEXT);
    }
    private void initializeLayout() {
        setLayout(new FlowLayout());
        add(statusLabel);
        add(timeLabel);
    }

    private void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.setRunning(false);
    }



}
