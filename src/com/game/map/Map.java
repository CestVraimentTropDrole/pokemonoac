package com.game.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Tile> tiles = new ArrayList<>();

    public Map(int[][] mapData, String[] tilePaths, int tileSize) {
        for (int i=0; i<mapData.length; i++) {
            for (int j=0; j<mapData[i].length; j++) {
                int tileIndex = mapData[i][j];

                if (tileIndex >= 0 && tileIndex < tilePaths.length) {
                    tiles.add(new Tile(tilePaths[tileIndex], j * tileSize, i * tileSize, tileSize));
                }
            }
        }
    }

    public void draw(Graphics g) {
        for (Tile tile : tiles) {
            tile.draw(g);
        }
    }
}
