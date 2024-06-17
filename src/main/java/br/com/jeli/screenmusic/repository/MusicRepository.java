package br.com.jeli.screenmusic.repository;

import br.com.jeli.screenmusic.domain.Music;
import br.com.jeli.screenmusic.domain.MusicCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicRepository extends JpaRepository<Music, Long> {

    List<Music> findByGender(MusicCategory category);
}
