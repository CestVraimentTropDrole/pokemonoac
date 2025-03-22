package com.game.entities;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player {
    int x, y; // Position du joueur
    int gridSize = 16; // Dimensions du joueur
    int speed = 4; // Vitesse du joueur
    private boolean moving = false; // État de déplacement
    private int targetX, targetY; // Destination du déplacement
    private Image sprite; // Image du joueur

    // Méthode Constructeur
    public Player(int startX, int startY, int scale) {
        this.x = startX;
        this.y = startY;
        this.targetX = x;
        this.targetY = y;

        this.gridSize *= scale;
        this.speed *= scale;

        this.sprite = new ImageIcon("assets/sprites/player_sprite.png").getImage();
    }

    // Méthodes Publiques
    public void update() {
        if (moving) {
            if (x < targetX)
                x += speed;
            if (x > targetX)
                x -= speed;
            if (y < targetY)
                y += speed;
            if (y > targetY)
                y -= speed;

            if (x == targetX && y == targetY) {
                moving = false; // Arrêt du déplacement
            }
        }
    }

    public void move(int dx, int dy) {
        if (!moving) { // Si le joueur n'est pas déjà en train de bouger
            targetX = x + dx * gridSize;
            targetY = y + dy * gridSize;
            moving = true;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, gridSize, gridSize, null);
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
}
