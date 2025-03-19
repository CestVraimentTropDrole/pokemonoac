package com.game.map;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Tile {
    private Image sprite;
    private int x,y;
    private int size;

    public Tile (String imagePath, int x, int y, int size) {
        this.sprite = new ImageIcon(imagePath).getImage();
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, x, y, size, size, null);
    }
}
