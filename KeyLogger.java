/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.keylogger.keylogger;


import javax.swing.SwingUtilities;

/**
 *
 * @author Rahul Teni
 */
public class KeyLogger {

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoggerManager logger = new LoggerManager();
            KeyloggerSimulator simulator = new KeyloggerSimulator(logger);
            simulator.createAndShowGUI();
        });
    }
}


