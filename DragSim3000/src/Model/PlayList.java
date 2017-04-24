package Model;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class PlayList {

    public static MediaPlayer musicChoice;
    ArrayList<MediaPlayer> songs = new ArrayList<>();
    URL url1 = getClass().getResource("/Ressources/ParadiseCity.mp3");
    URL url2 = getClass().getResource("/Ressources/ThunderStruck.mp3");
    URL url3 = getClass().getResource("/Ressources/Highway.mp3");
    URL url4 = getClass().getResource("/Ressources/SSS.mp3");
    URL url5 = getClass().getResource("/Ressources/DeadOrAlive.mp3");
    URL url6 = getClass().getResource("/Ressources/GiveItAway.mp3");
    URL url7 = getClass().getResource("/Ressources/ThePretender.mp3");
    URL url8 = getClass().getResource("/Ressources/LearnToFly.mp3");
    URL url9 = getClass().getResource("/Ressources/SLTS.mp3");
    URL url10 = getClass().getResource("/Ressources/Californication.mp3");
    MediaPlayer s1 = new MediaPlayer(new Media(url1.toString()));
    MediaPlayer s2 = new MediaPlayer(new Media(url2.toString()));
    MediaPlayer s3 = new MediaPlayer(new Media(url3.toString()));
    MediaPlayer s4 = new MediaPlayer(new Media(url4.toString()));
    MediaPlayer s5 = new MediaPlayer(new Media(url5.toString()));
    MediaPlayer s6 = new MediaPlayer(new Media(url6.toString()));
    MediaPlayer s7 = new MediaPlayer(new Media(url7.toString()));
    MediaPlayer s8 = new MediaPlayer(new Media(url8.toString()));
    MediaPlayer s9 = new MediaPlayer(new Media(url9.toString()));
    MediaPlayer s10 = new MediaPlayer(new Media(url10.toString()));

    public PlayList() {
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
        Collections.shuffle(songs);
        musicChoice = songs.get(0);
        musicChoice.play();

        musicChoice.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                songs.remove(0);
                songs.get(0).play();
            }
        });

    }
}
