package com.game.map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Tileset {
    private BufferedImage tileset;
    private int tileSize;
    private ArrayList<BufferedImage> tiles;

    public Tileset(String filePath) {
        tiles = new ArrayList<>();
        try {
            tileset = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        tileSize = 16 * 4;

        int columns = tileset.getWidth(null) / tileSize;
        int rows = tileset.getHeight(null) / tileSize;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                BufferedImage tile = tileset.getSubimage(x * tileSize, y * tileSize, tileSize, tileSize);
                tiles.add(tile);
            }
        }
    }

    // Getters
    public BufferedImage getImage(int index) { return tiles.get(index); }
    public int getLenght() { return tiles.size(); }
}
