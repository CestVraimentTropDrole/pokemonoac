package com.game.audio;

import java.io.IOException;
import javax.sound.sampled.*;
import java.io.File;

public class SoundPlayer {
    public String musicPath;
    private Clip clip;

    // Méthode Constructeur
    public SoundPlayer(String filePath) {
        load(filePath);
    }

    // Méthodes Publiques
    public void play() {
        if (clip != null) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void load(String filePath) {
        stop();
        try {
            File file = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            musicPath = filePath;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
            clip = null;
        }
    }

    // Getters
    public String getMusic() { return musicPath; }  // Renvoie le chemin de la musique qui est jouée
    public boolean getRunning() { return clip.isRunning(); }    // Renvoie si de la musique est jouée
}
