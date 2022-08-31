package com.rexie.songr.controllers;


import com.rexie.songr.Album;
import com.rexie.songr.SongrApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    SongrApplication SongrApplication;

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

}
