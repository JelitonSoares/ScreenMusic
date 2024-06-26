package br.com.jeli.screenmusic.main;

import br.com.jeli.screenmusic.domain.Artist;
import br.com.jeli.screenmusic.domain.Music;
import br.com.jeli.screenmusic.domain.MusicCategory;
import br.com.jeli.screenmusic.dtos.ArtistDTO;
import br.com.jeli.screenmusic.dtos.MusicDTO;
import br.com.jeli.screenmusic.repository.ArtistRepository;
import br.com.jeli.screenmusic.repository.MusicRepository;
import br.com.jeli.screenmusic.service.ArtistService;
import br.com.jeli.screenmusic.service.MusicService;
import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ArtistService artistService;
    private MusicService musicService;
    private Artist artist;

    public Main(ArtistRepository artistRepository, MusicRepository musicRepository) {
        this.artistService = new ArtistService(artistRepository);
        this.musicService = new MusicService(musicRepository);
    }

    public void execute() {
        System.out.println("*****_Bem vindo ao ScreeMusic_*****");
        Integer choose = -1;

        while (choose != 0) {

            choose = menuChoose();
            switch (choose) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerMusic();
                    break;
                case 3:
                    listMusics();
                    break;
                case 4:
                    listArtist();
                    break;
                case 5:
                    searchMusicByArtist();
                    break;
                case 6:
                    searchMusicByGender();
                    break;
                case 0:
                    System.out.println("Finishing...");
                    break;
                default:
                    System.out.println("Invalid Option!!");
            }

        }
    }


    private void showMenu() {
        System.out.println("""
                1 - Cadastrar Artistas
                2 - Cadastrar Musicas
                3 - Listar Musicas
                4 - Listar Artistas
                5 - Buscar Música por Artista
                6 - Buscar Música por Gênero
                
                
                0 - Sair
                """);
    }

    private Integer menuChoose() {
        showMenu();
        Integer choose = scanner.nextInt();
        scanner.nextLine();

        return choose;
    }

    private void registerArtist() {
        System.out.println("Digite o nome do artista: ");
        String artistName = scanner.nextLine();

        System.out.println("Digite o tipo (Solo/Dupla/Banda): ");
        String artistType = scanner.nextLine();

        ArtistDTO artistDTO = new ArtistDTO(artistName, artistType);

        artistService.register(artistDTO);

        System.out.println("Artista cadastrado com sucesoo!!");
    }

    private void searchArtistByName() {
        System.out.println("Digite o nome do artista: ");
        String artistName = scanner.nextLine();

        this.artist = artistService.findByName(artistName);
    }
    private void registerMusic() {
        List<MusicDTO> musicDTOList = new ArrayList<>();
        Boolean option = true;
        while (option) {
            System.out.println("Deseja cadastrar uma música?(S/N) ");
            String optionString = scanner.nextLine();

            if (optionString.equalsIgnoreCase("s")) {
                System.out.println("Digite o nome da música: ");
                String musicName = scanner.nextLine();

                System.out.println("Digite o album da música: ");
                String musicAlbum = scanner.nextLine();

                System.out.println("Digite o gênero da música(Sertanejo/Funk/Eletrônica/Pagode/Rock/Pop): ");
                String musicGender = scanner.nextLine();

                System.out.println("Digite a data de lançamento da música: ");
                String releaseDate = scanner.nextLine();

                musicDTOList.add(new MusicDTO(musicName, musicAlbum, musicGender, releaseDate));
            } else if (optionString.equalsIgnoreCase("n")) {
                option = false;
            } else
                System.out.println("Invalid Parameter!!");
        }

        searchArtistByName();

        List<Music> musics = musicDTOList.stream()
                .map( d -> new Music(d))
                .collect(Collectors.toList());

        this.artist.setMusics(musics);

        artistService.save(this.artist);
    }

    public void listMusics() {
        List<Music> musics = musicService.findAll();
        musics.forEach(System.out::println);
    }

    public void listArtist() {
        List<Artist> artists = artistService.findAll();
        artists.forEach(System.out::println);
    }

    public void searchMusicByArtist() {
        listArtist();
        searchArtistByName();

        List<Music> musics = artistService.findMusicByArtist(this.artist);
        musics.forEach(m ->
                System.out.println("Nome: " + m.getName() + ", Album: " + m.getAlbum() +
                        ", Gênero: " + m.getGender() + ", Lançamento: " + m.getReleaseDate()));
    }

    public void searchMusicByGender() {
        System.out.println("Digite qual gênero deseja buscar: ");
        String nameGender = scanner.nextLine();
        MusicCategory category = MusicCategory.fromPortuguese(nameGender);

        List<Music> musicsFound = this.musicService.findByGender(category);

        musicsFound.forEach(System.out::println);
    }
}
