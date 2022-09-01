package com.rexie.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String title;
    private String name;
    private Integer songCount;
    private Integer length;
    private  String artistPicUrl;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    protected Album() {
    }

    public Album(String title, String artist, Integer songCount, Integer length, String artistPicUrl) {
        this.title = title;
        this.name = artist;
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
        return name;
    }

    public void setArtist(String artist) {
        this.name = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(Integer songCount) {
        this.songCount = songCount;
    }

    public int getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getArtistPicUrl() {
        return artistPicUrl;
    }

    public void setArtistPicUrl(String artistPicUrl) {
        this.artistPicUrl = artistPicUrl;
    }
}
