package com.game.input;

import com.game.entities.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyboardInput implements KeyListener {
    private Player player;

    public KeyboardInput(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> player.move(-1, 0);
            case KeyEvent.VK_RIGHT -> player.move(1, 0);
            case KeyEvent.VK_UP -> player.move(0, -1);
            case KeyEvent.VK_DOWN -> player.move(0, 1);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
