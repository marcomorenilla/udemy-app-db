import frame.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //OS Appearence for GUI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        //Entrance Swing method which handles event dispatch manager (edt)
        //Abstract windows toolkit (AWT)

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame();
            }
        });

    }
}
