package com.rexie.songr.controllers;


import com.rexie.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

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
