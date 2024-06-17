package br.com.jeli.screenmusic.service;

import br.com.jeli.screenmusic.domain.Artist;
import br.com.jeli.screenmusic.domain.Music;
import br.com.jeli.screenmusic.dtos.ArtistDTO;
import br.com.jeli.screenmusic.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;

public class ArtistService {

    private ArtistRepository repository;


    public ArtistService(ArtistRepository repository) {
        this.repository = repository;
    }

    public void register(ArtistDTO artistDTO) {
        Artist artist = new Artist(artistDTO);
        repository.save(artist);
    }

    public Artist findByName(String name) {
        Optional<Artist> artistFounded = repository.findByNameContainingIgnoreCase(name);

        if (artistFounded.isEmpty()) {
            throw new RuntimeException("Artist not found!!");
        }

        return artistFounded.get();
    }

    public void save(Artist artist) {
        this.repository.save(artist);
    }

    public List<Music> findMusicByArtist(Artist artist) {
        return this.repository.findMusicByArtist(artist);
    }

    public List<Artist> findAll() {
        return this.repository.findAll();
    }
}
