package br.com.jeli.screenmusic.service;

import br.com.jeli.screenmusic.domain.Music;
import br.com.jeli.screenmusic.repository.MusicRepository;

import java.util.List;

public class MusicService {
    private MusicRepository repository;

    public MusicService(MusicRepository repository) {
        this.repository = repository;
    }

    public List<Music> findAll() {
        return this.repository.findAll();
    }
}
