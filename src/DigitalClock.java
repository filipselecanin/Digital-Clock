import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock {

    private JLabel timeLabel;

    public DigitalClock () {

        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setLayout(new FlowLayout());

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Calibri", Font.BOLD, 24));

        frame.add(timeLabel);
        frame.setVisible(true);

        // Start the clock update
        updateClock();
    }

    private void updateClock(){

        Thread clockThread = new Thread(() -> {
            while (true) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                String time = simpleDateFormat.format(now);
                timeLabel.setText(time);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        clockThread.start();
    }
}
