package com.game.core;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        final int WIDTH = 800;
        final int HEIGHT = 750;
        
        JFrame frame = new JFrame("Pokémon OAC - Test");
        GamePanel gamePanel = new GamePanel(WIDTH, HEIGHT);

        frame.add(gamePanel);
        frame.setSize(800,750);  // Dimensions GBC fois 5
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
