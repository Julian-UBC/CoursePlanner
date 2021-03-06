package ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class ThankYouPage extends JFrame {

    Timer timer;
    TimerTask exitApp;

    // EFFECTS: initializes a thank you page
    public ThankYouPage() {
        setThankYou();
        setTimer();
        exit();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setTitle("Course Planning App");
        this.pack();

        this.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: set the thank you image
    private void setThankYou() {
        ImageIcon thankYouImage = new ImageIcon("data/thankyou.png");

        JLabel thankYouLabel = new JLabel();
        thankYouLabel.setIcon(thankYouImage);

        this.add(thankYouLabel);
    }

    // EFFECTS: set the timer to close the app
    private void setTimer() {
        timer = new Timer();
        exitApp = new TimerTask() {
            public void run() {
                System.exit(0);
            }
        };
    }

    // EFFECTS: close the app
    private void exit() {
        playSound("data/YoureWelcome.wav");
        timer.schedule(exitApp, new Date(System.currentTimeMillis() + 5 * 1000));
    }

    // EFFECTS: play sound effects
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
