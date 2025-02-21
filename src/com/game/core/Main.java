package com.game.core;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        JFrame frame = new JFrame("Pokémon OAC - Test");
        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.setSize(800,750);  // Dimensions GBC times 5
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
