package br.com.jeli.screenmusic;

import br.com.jeli.screenmusic.main.Main;
import br.com.jeli.screenmusic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmusicApplication implements CommandLineRunner {
	@Autowired
	private ArtistRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ScreenmusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running...");
		new Main(this.repository).execute();
	}
}
