package com.keylogger.keylogger;


import java.awt.event.KeyEvent;

public class LoggerManager {
    public void logKeyEvent(KeyEvent event, long timestamp) {
        System.out.println("Logged Key: " + KeyEvent.getKeyText(event.getKeyCode()) + " at " + timestamp);
    }
}
