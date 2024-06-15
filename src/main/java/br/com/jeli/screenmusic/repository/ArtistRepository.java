package br.com.jeli.screenmusic.repository;

import br.com.jeli.screenmusic.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
