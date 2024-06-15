package br.com.jeli.screenmusic.domain;

import br.com.jeli.screenmusic.dtos.MusicDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String album;
    @ManyToOne
    private Artist singer;
    @ManyToOne
    private Artist featuring;
    @Enumerated(value = EnumType.STRING)
    private MusicCategory gender;
    private LocalDate releaseDate;

    public Music() {

    }

    public Music(MusicDTO musicDTO) {
        this.name = musicDTO.name();
        this.album = musicDTO.album();
        this.gender = MusicCategory.fromPortuguese(musicDTO.gender());
         try {
             this.releaseDate = LocalDate.parse(musicDTO.releaseDate());
        } catch (DateTimeParseException ex) {
            this.releaseDate = null;
        }
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artist getSinger() {
        return singer;
    }

    public void setSinger(Artist singer) {
        this.singer = singer;
    }

    public Artist getFeaturing() {
        return featuring;
    }

    public void setFeaturing(Artist featuring) {
        this.featuring = featuring;
    }

    public MusicCategory getGender() {
        return gender;
    }

    public void setGender(MusicCategory gender) {
        this.gender = gender;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
