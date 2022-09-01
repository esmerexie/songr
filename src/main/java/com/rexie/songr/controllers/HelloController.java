package com.rexie.songr.controllers;


import com.rexie.songr.Album;
import com.rexie.songr.Song;
import com.rexie.songr.SongrApplication;
import com.rexie.songr.repositories.AlbumSongRepository;
import com.rexie.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    SongrApplication SongrApplication;
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumSongRepository albumSongRepository;

    @GetMapping("/hello")
    public String getHi(){
        return "hello";
    }

    @GetMapping("/capitalize/{word}")
    @ResponseBody
    public String getCapitalize(@PathVariable String word, Model m){
        m.addAttribute("word", word);

        return word.toUpperCase();
    }

    @GetMapping("/albums")
    public String albums(Model m){
        Album[] albums = Album.testingAlbums();
        m.addAttribute("albumsCollection", albums);
        return "albums";
    }

   @GetMapping("/songs")
    public String getAllSongs(Model m){
        List<Song> songs = songRepository.findAll();

        m.addAttribute("songs", songs);
        return "/songs";
   }

   @PostMapping("/add-song")
    public RedirectView addSongToAlbum(String songName, Integer length, String albumName){
        Album album = albumSongRepository.findByName(albumName);

        Song newSong = new Song(songName, length, albumName);
        albumSongRepository.save(newSong);

        return new RedirectView("/");
   }

}
