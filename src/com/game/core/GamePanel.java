package com.game.core;

import javax.swing.JPanel;
import java.awt.*;
// import java.awt.image.BufferedImage;
// import java.io.File;
// import javax.imageio.ImageIO;

import com.game.entities.Player;
import com.game.input.KeyboardInput;
import com.game.map.Map;


public class GamePanel extends JPanel implements Runnable {
    private Player player;
    private boolean running;
    private int WIDTH, HEIGHT;
    private final int FPS = 30;  // Limite le jeu à 30 images/seconde
    private int SCALE;

    private Map gameMap;
    // private BufferedImage backgroundImage;

    public GamePanel(int screenW, int screenH, int scale) {
        this.WIDTH = screenW;
        this.HEIGHT = screenH;
        this.SCALE = scale;
        this.player = new Player(0, 0, WIDTH, HEIGHT, SCALE);  // Initialisation du joueur
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new KeyboardInput(player));  // Gestion des touches
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Charge l'image de fond
        // try {
            // backgroundImage = ImageIO.read(new File("assets/backgrounds/background.png"));
        // } catch (Exception e) {
            // e.printStackTrace();
        // }

        int[][] mapData = {
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1}
        };

        // Chemins des images des tiles
        String[] tilePaths = {
            "assets/tiles/grass.png",
            "assets/tiles/path.png"
        };

        gameMap = new Map(mapData, tilePaths, 16 * SCALE);

        running = true;
        new Thread(this).start();  // Démarre la boucle du jeu
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        gameMap.draw(g);

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
