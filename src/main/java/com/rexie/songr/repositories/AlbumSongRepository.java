package com.rexie.songr.repositories;

import com.rexie.songr.Album;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlbumSongRepository extends JpaRepository<Album, Long>{
    public Album findByName(String name);
}
