package com.game.map;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Tile> tiles = new ArrayList<>();
    private int tileSize = 16; // Taille des tiles

    // Méthode Constructeur
    public Map(String mapFile, String[] tilePaths, int scale) {
        tileSize *= scale;  // Mettre à l'échelle les tiles
        int[][] mapData = readCSV(mapFile);

        for (int i=0; i<mapData.length; i++) {  // Pour chaque colonne de la map
            for (int j=0; j<mapData[i].length; j++) {   // Pour chaque ligne de la map
                int tileIndex = mapData[i][j];

                if (tileIndex >= 0 && tileIndex < tilePaths.length) {
                    tiles.add(new Tile(tilePaths[tileIndex], j * tileSize, i * tileSize, tileSize));
                }
            }
        }
    }

    // Méthodes Publiques
    public void draw(Graphics g) {
        for (Tile tile : tiles) {
            tile.draw(g);
        }
    }

    // Méthodes Privées
    private int[][] readCSV(String filePath) {
        ArrayList<int[]> data = new ArrayList<>();  // Liste pour stocker les lignes

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {    // Ouvre le fichier CSV
            String line;
            while ((line = br.readLine()) != null) {    // Pour chaque ligne
                String[] values = line.split(",");  // Sépare les valeurs
                int[] row = new int[values.length]; //Créé un tableau pour stocker les nombres

                for (int i=0; i<values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);   // Convertit la valeur en entier
                }
                data.add(row);  // Ajoute la ligne au tableau
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[][] array = data.toArray(new int[0][]); // Convertit en tableau de valeurs
        return(array);
    }
}
