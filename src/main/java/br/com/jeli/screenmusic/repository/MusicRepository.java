package br.com.jeli.screenmusic.repository;

import br.com.jeli.screenmusic.domain.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
