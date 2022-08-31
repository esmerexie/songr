package com.rexie.songr;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String title;
    private String artist;
    private int songCount;
    private int length;
    private  String artistPicUrl;

    public Album(String title, String artist, int songCount, int length, String artistPicUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.artistPicUrl = artistPicUrl;
    }

    public static Album[] testingAlbums(){
        Album test1 = new Album("Alaska", "Valient Hearts", 1, 1111, "https://valianthearts.bandcamp.com/track/alaska");

        Album[] result = new Album[1];
        result[0] = test1;

        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getArtistPicUrl() {
        return artistPicUrl;
    }

    public void setArtistPicUrl(String artistPicUrl) {
        this.artistPicUrl = artistPicUrl;
    }
}
