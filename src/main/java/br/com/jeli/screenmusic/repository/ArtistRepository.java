package br.com.jeli.screenmusic.repository;

import br.com.jeli.screenmusic.domain.Artist;
import br.com.jeli.screenmusic.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String name);
    @Query("SELECT m FROM Artist a JOIN a.musics m WHERE m.singer = :artist")
    List<Music> findMusicByArtist(Artist artist);
}
