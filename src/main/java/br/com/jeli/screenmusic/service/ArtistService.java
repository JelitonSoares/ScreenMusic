package br.com.jeli.screenmusic.service;

import br.com.jeli.screenmusic.domain.Artist;
import br.com.jeli.screenmusic.dtos.ArtistDTO;
import br.com.jeli.screenmusic.repository.ArtistRepository;

public class ArtistService {

    private ArtistRepository repository;


    public ArtistService(ArtistRepository repository) {
        this.repository = repository;
    }

    public void register(ArtistDTO artistDTO) {
        Artist artist = new Artist(artistDTO);
        repository.save(artist);
    }
}
