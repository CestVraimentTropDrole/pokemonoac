package com.game.map;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Tile {
    private Image sprite;
    private int x,y;
    private int size;

    // Méthode Constructeur
    public Tile (BufferedImage tileImage, int x, int y, int size) {
        this.sprite = tileImage;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    // Méthodes Publiques
    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, size, size, null);
    }
}
