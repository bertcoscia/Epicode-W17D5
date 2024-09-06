package bertcoscia.Epicode_W17D5;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import bertcoscia.Epicode_W17D5.entities.Postazione;
import bertcoscia.Epicode_W17D5.entities.User;
import bertcoscia.Epicode_W17D5.exceptions.ValidationException;
import bertcoscia.Epicode_W17D5.services.EdificiService;
import bertcoscia.Epicode_W17D5.services.PostazioniService;
import bertcoscia.Epicode_W17D5.services.PrenotazioniService;
import bertcoscia.Epicode_W17D5.services.UsersService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EpicodeW17D5Application {
	@Autowired
	EdificiService edificiService;
	@Autowired
	PostazioniService postazioniService;
	@Autowired
	PrenotazioniService prenotazioniService;
	@Autowired
	UsersService usersService;

	static Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(EpicodeW17D5Application.class, args);
	}

	@Autowired
	public void runScanner() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Scegli cosa fare");
		System.out.println("1. Registra un nuovo utente");
		System.out.println("2. Prenota una postazione");
		System.out.println("0. Esci");
		String action1;
		do {
			action1 = scanner.nextLine();
			switch (action1) {
				case "1": // Registra un nuovo utente
					System.out.println("Inserisci il nome");
					String name = scanner.nextLine();
					System.out.println("Inserisci il cognome");
					String surname = scanner.nextLine();
					System.out.println("Inserisci il tuo username");
					String username = scanner.nextLine();
					System.out.println("Inserisci la tua email");
					String email = scanner.nextLine();
					try {
						User user = new User(name, surname, username, email);
						usersService.save(user);
					} catch (ValidationException e) {
					System.err.println(e.getMessage());
				}
					break;
				case "2": // Prenota una postazione
					System.out.println("Scegli la città");
					System.out.println("1. Roma");
					System.out.println("2. Milano");
					System.out.println("0. Torna indietro");
					String cityAction;
					do {
						cityAction = scanner.nextLine();
						switch (cityAction) {
							case "1": // Roma
								Edificio edificioRoma = edificiService.findByCityIgnoreCase("roma");
								List<Postazione> listPostazioneRoma = postazioniService.find;
								for (Postazione postazione : listPostazioneRoma) {
									System.out.println(postazione);
								}
						}
					} while (!cityAction.equals("0"));

			}
		} while (!action1.equals("0"));

	}
}
