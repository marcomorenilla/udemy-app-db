package frame;

import javax.swing.JLabel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer extends Thread {

    private boolean running;
    private JLabel timeLabel;
    private SimpleDateFormat dateFormat;

    public Timer(JLabel timeLabel) {
        initializeVariables(timeLabel);
    }

    private void initializeVariables(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        running = true;
    }

    @Override
    public void run() {
        while (running){
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            timeLabel.setText(dateFormat.format(date));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setRunning(boolean running) {
        this.running=running;
    }


}
