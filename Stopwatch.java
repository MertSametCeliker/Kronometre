import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private Timer timer;
    private int seconds = 0;
    private JLabel timeLabel;

    public Stopwatch() {
        setTitle("Kronometre");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("0:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        add(timeLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Başlat");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.NORTH);

        JButton stopButton = new JButton("Durdur");
        stopButton.addActionListener(this);
        add(stopButton, BorderLayout.SOUTH);

        timer = new Timer(1000, e -> {
            seconds++;
            updateLabel();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Başlat")) {
            timer.start();
        } else if (command.equals("Durdur")) {
            timer.stop();
        }
    }

    private void updateLabel() {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        timeLabel.setText(String.format("%d:%02d:%02d", hours, minutes, secs));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.setVisible(true);
        });
    }
}
