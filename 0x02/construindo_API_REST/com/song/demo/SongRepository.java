package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository{
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        for (Song song : list) {
            if (song.getId().equals(id)) {
                return song;
            }
        }
        return null;
    }

    public void addSong(Song song) {
        if(song != null) {
            list.add(song);
        }
    }

    public void updateSong(Song song) {
        Song c = getSongById(song.getId());
        list.set(list.indexOf(c), song);
    }

    public void removeSong(Song song) {
        if (list.contains(song)) {
            list.remove(song);
        }
    }
}
