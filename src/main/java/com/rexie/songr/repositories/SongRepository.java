package com.rexie.songr.repositories;

import com.rexie.songr.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
