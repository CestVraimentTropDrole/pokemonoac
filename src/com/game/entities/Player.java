package com.game.entities;

import java.awt.Graphics;


public class Player {
    int x,y;  // Position du joueur
    int width,height;  // Dimensions du joueur
    int speed;  // Vitesse du joueur

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 80;
        this.height = 80;
        this.speed = 80;
    }

    // Fonctions de déplacement du joueur
    public void moveLeft() { x -= speed; }
    public void moveRight() { x += speed; }
    public void moveUp() { y -= speed; }
    public void moveDown() { y += speed; }

    public void draw(Graphics g) {
        g.fillRect(x, y, width, height);  // Dessine le joueur
    }

    // Getters pour la position
    public int getX() { return x; }
    public int getY() { return y; }
}
