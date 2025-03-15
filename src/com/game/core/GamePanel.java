package com.game.core;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import com.game.entities.Player;
import com.game.input.KeyboardInput;


public class GamePanel extends JPanel implements Runnable {
    private Player player;
    private boolean running;
    private final int FPS = 30;  // Limite le jeu à 30 images/seconde

    public GamePanel() {
        this.player = new Player(0, 0);  // Initialisation du joueur
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new KeyboardInput(player));  // Gestion des touches

        running = true;
        new Thread(this).start();  // Démarre la boucle du jeu
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerTick = 1_000_000_000.0 / FPS;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            while (delta >= 1) {
                update();  // Mise à jour des positions
                delta--;
            }

            repaint();  // Redessine l'écran
        }
    }

    private void update() {
        player.update();  // Met à jour la position du joueur
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        player.draw(g); // Dessiner le joueur
    }
    
}
