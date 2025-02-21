package com.game.entities;

import java.awt.Color;
import java.awt.Graphics;
// import java.awt.Image;
// import javax.swing.ImageIcon;


public class Player {
    int x,y;  // Position du joueur
    int gridSize = 80;  // Dimensions du joueur
    int speed = 20;  // Vitesse du joueur
    private boolean moving = false;  // État de déplacement
    private int targetX, targetY;  // Destination du déplacement

    //private Image sprite;  // Image du joueur

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.targetX = x;
        this.targetY = y;
        // A tester quand image mise
        // this.sprite = new ImageIcon("assets/sprites/player.png").getImage();
    }

    public void update() {
        if (moving) {
            if (x < targetX) x += speed;
            if (x > targetX) x -= speed;
            if (y < targetY) y += speed;
            if (y > targetY) y -= speed;

            if (x == targetX && y == targetY) {
                moving = false;  // Arrêt du déplacement
            }
        }
    }

    public void move(int dx, int dy) {
        if (!moving) {  // Si le joueur n'est pas déjà en train de bouger
            targetX = x + dx * gridSize;
            targetY = y + dy * gridSize;
            moving = true;
        }
    }

    public void draw(Graphics g) {
        // A tester après l'image
        // g.drawImage(sprite, x, y, null);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, gridSize, gridSize);
    }

}
