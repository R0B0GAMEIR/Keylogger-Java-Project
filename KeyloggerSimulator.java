package com.keylogger.keylogger;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyloggerSimulator {
    private LoggerManager logger;
    private JTextArea logArea;

    public KeyloggerSimulator(LoggerManager logger) {
        this.logger = logger;
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Keylogger Defense Emulator (Sandbox)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        logArea = new JTextArea();
        logArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logArea);

        JLabel instructions = new JLabel("Start typing anywhere in this window...");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(instructions, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().add(panel);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.setVisible(true);

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
            if (event.getID() == KeyEvent.KEY_PRESSED) {
                long timestamp = System.currentTimeMillis();
                String keyText = KeyEvent.getKeyText(event.getKeyCode());
                String formattedTime = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(timestamp));
                logArea.append("Key: " + keyText + " | Time: " + formattedTime + "\n");
                logger.logKeyEvent(event, timestamp);
            }
            return false;
        });
    }
}
