package com.game.core;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws Exception {
        final int SCALE = 4;
        final int WIDTH = 160 * SCALE;
        final int HEIGHT = 144 * SCALE;

        JFrame frame = new JFrame("Pokémon OAC - Test");
        GamePanel gamePanel = new GamePanel(WIDTH, HEIGHT, SCALE);

        frame.add(gamePanel);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack(); 
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
