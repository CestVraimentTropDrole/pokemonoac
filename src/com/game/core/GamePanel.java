package com.game.core;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import com.game.entities.Player;


public class GamePanel extends JPanel implements KeyListener {
    private Player player;

    public GamePanel() {
        this.player = new Player(100, 100);  // Initialisation du joueur
        addKeyListener(this);  // Écouteur du clavier
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        player.draw(g); // Dessiner le joueur
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT -> player.moveLeft();
            case KeyEvent.VK_RIGHT -> player.moveRight();
            case KeyEvent.VK_UP -> player.moveUp();
            case KeyEvent.VK_DOWN -> player.moveDown();
        }
        repaint();  // Redessine la fenêtre après un mouvement
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    
}
