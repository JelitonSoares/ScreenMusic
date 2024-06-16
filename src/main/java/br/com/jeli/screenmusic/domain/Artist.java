package br.com.jeli.screenmusic.domain;

import br.com.jeli.screenmusic.dtos.ArtistDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ArtistCategory type;
    @OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Music> musics;

    public Artist() {

    }

    public Artist(ArtistDTO artistDTO) {
        this.name = artistDTO.name();
        this.type = ArtistCategory.fromPortuguese(artistDTO.type());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistCategory getType() {
        return type;
    }

    public void setType(ArtistCategory type) {
        this.type = type;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        musics.forEach(m -> m.setSinger(this));
        this.musics = musics;
    }

}
