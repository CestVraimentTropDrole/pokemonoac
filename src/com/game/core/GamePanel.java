package com.game.core;

import javax.swing.JPanel;
import java.awt.*;

import com.game.entities.Player;
import com.game.input.KeyboardInput;
import com.game.map.Map;
import com.game.audio.SoundPlayer;


public class GamePanel extends JPanel implements Runnable {
    private Player player;
    private boolean running;
    private int WIDTH, HEIGHT;
    private final int FPS = 30;  // Limite le jeu à 30 images/seconde
    private int SCALE;
    private Map gameMap;
    private SoundPlayer bgm;    // Player audio

    // Méthode Constructeur
    public GamePanel(int screenW, int screenH, int scale) {
        this.WIDTH = screenW;
        this.HEIGHT = screenH;
        this.SCALE = scale;
        this.player = new Player(0, 0, SCALE);  // Initialisation du joueur
        bgm = new SoundPlayer("assets/musics/new_bark_town.wav");   // Initialisation de la musique
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(new KeyboardInput(player));  // Gestion des touches
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        String mapData = "assets/maps/map.csv"; // Données de la map

        // Chemins des images des tiles
        String[] tilePaths = {
            "assets/tiles/grass.png",
            "assets/tiles/path.png",
            "assets/tiles/water.png",
        };

        gameMap = new Map(mapData, tilePaths, SCALE);

        running = true;
        new Thread(this).start();  // Démarre la boucle du jeu
    }

    @Override
    public void addNotify() {   // La musique se lance quand la fenêtre s'ouvre
        super.addNotify();
        bgm.loop();
        bgm.play();
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

    // Méthodes Privées
    private void update() {
        player.update();  // Met à jour la position du joueur

        if (player.getX() > 200 && bgm.getMusic() != "assets/musics/opening1.wav") {
            bgm.load("assets/musics/opening1.wav");
            bgm.play();
        }
    }
}
