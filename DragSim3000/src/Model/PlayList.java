package Model;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class PlayList {

    private ArrayList<MediaPlayer> songs = new ArrayList<>();
    private boolean playing = false;
    private URL url1 = getClass().getResource("/Ressources/ParadiseCity.mp3");
    private URL url2 = getClass().getResource("/Ressources/ThunderStruck.mp3");
    private URL url3 = getClass().getResource("/Ressources/Highway.mp3");
    private URL url4 = getClass().getResource("/Ressources/SSS.mp3");
    private URL url5 = getClass().getResource("/Ressources/DeadOrAlive.mp3");
    private URL url6 = getClass().getResource("/Ressources/GiveItAway.mp3");
    private URL url7 = getClass().getResource("/Ressources/ThePretender.mp3");
    private URL url8 = getClass().getResource("/Ressources/LearnToFly.mp3");
    private URL url9 = getClass().getResource("/Ressources/SLTS.mp3");
    private URL url10 = getClass().getResource("/Ressources/Californication.mp3");
    private MediaPlayer s1 = new MediaPlayer(new Media(url1.toString()));
    private MediaPlayer s2 = new MediaPlayer(new Media(url2.toString()));
    private MediaPlayer s3 = new MediaPlayer(new Media(url3.toString()));
    private MediaPlayer s4 = new MediaPlayer(new Media(url4.toString()));
    private MediaPlayer s5 = new MediaPlayer(new Media(url5.toString()));
    private MediaPlayer s6 = new MediaPlayer(new Media(url6.toString()));
    private MediaPlayer s7 = new MediaPlayer(new Media(url7.toString()));
    private MediaPlayer s8 = new MediaPlayer(new Media(url8.toString()));
    private MediaPlayer s9 = new MediaPlayer(new Media(url9.toString()));
    private MediaPlayer s10 = new MediaPlayer(new Media(url10.toString()));

    public PlayList() {
    }

    private void fill() {
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        songs.add(s5);
        songs.add(s6);
        songs.add(s7);
        songs.add(s8);
        songs.add(s9);
        songs.add(s10);
    }

    public void getSong() {
        if (!playing || songs.isEmpty()) {
            fill();
            Collections.shuffle(songs);
            songs.get(0).play();
            playing = true;
        }

        songs.get(0).setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                songs.remove(0);
                getSong();
            }
        });

    }
}
