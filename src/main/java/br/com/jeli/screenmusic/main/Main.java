package br.com.jeli.screenmusic.main;

import br.com.jeli.screenmusic.dtos.ArtistDTO;
import br.com.jeli.screenmusic.repository.ArtistRepository;
import br.com.jeli.screenmusic.service.ArtistService;

import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private ArtistService artistService;

    public Main(ArtistRepository repository) {
        this.artistService = new ArtistService(repository);
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
                4 - Buscar Musica por Artista
                5 - Buscar Musica por Genero
                
                
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

    private void registerMusic() {
        System.out.println("Registering...");

    }
}
