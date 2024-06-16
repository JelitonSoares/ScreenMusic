package br.com.jeli.screenmusic.repository;

import br.com.jeli.screenmusic.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String name);
}
