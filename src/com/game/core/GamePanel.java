package com.game.core;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import com.game.entities.Player;
import com.game.input.KeyboardInput;


public class GamePanel extends JPanel implements Runnable {
    private Player player;
    private boolean running;
    private int WIDTH, HEIGHT;
    private final int FPS = 30;  // Limite le jeu à 30 images/seconde

    private BufferedImage backgroundImage;

    public GamePanel(int screenW, int screenH) {
        this.WIDTH = screenW;
        this.HEIGHT = screenH;
        this.player = new Player(0, 0, WIDTH, HEIGHT);  // Initialisation du joueur
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new KeyboardInput(player));  // Gestion des touches

        // Charge l'image de fond
        try {
            backgroundImage = ImageIO.read(new File("assets/backgrounds/background.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        running = true;
        new Thread(this).start();  // Démarre la boucle du jeu
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Affiche l'image de fond
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }

        player.draw(g); // Affiche le joueur
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
}
