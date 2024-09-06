package bertcoscia.Epicode_W17D5.runners;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import bertcoscia.Epicode_W17D5.entities.Postazione;
import bertcoscia.Epicode_W17D5.entities.Prenotazione;
import bertcoscia.Epicode_W17D5.entities.User;
import bertcoscia.Epicode_W17D5.enums.PostazioneTipo;
import bertcoscia.Epicode_W17D5.exceptions.ValidationException;
import bertcoscia.Epicode_W17D5.services.EdificiService;
import bertcoscia.Epicode_W17D5.services.PostazioniService;
import bertcoscia.Epicode_W17D5.services.PrenotazioniService;
import bertcoscia.Epicode_W17D5.services.UsersService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MyRunner implements CommandLineRunner {
    Faker faker = new Faker(Locale.ITALY);
    @Autowired
    EdificiService edificiService;
    @Autowired
    PostazioniService postazioniService;
    @Autowired
    PrenotazioniService prenotazioniService;
    @Autowired
    UsersService usersService;

    @Autowired
    AnnotationConfigApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        /*try {
            Edificio roma = new Edificio("Roma - Colosseo", "Roma", faker.address().fullAddress());
            Edificio milano = new Edificio("Milano - Porta Nuova", "Milano", faker.address().fullAddress());
            edificiService.save(roma);
            edificiService.save(milano);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }*/

        /*try {
            User newUser = new User(faker.name().firstName(), faker.name().lastName(), faker.name().username(),faker.internet().emailAddress());
            usersService.save(newUser);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }*/

        try {
            Postazione p1Milano = new Postazione(faker.friends().quote(), PostazioneTipo.PRIVATO, edificiService.findById("8683fad9-eac9-48a2-9304-140ffd723a62"));
            Postazione p2Milano = new Postazione(faker.friends().quote(), PostazioneTipo.OPENSPACE, edificiService.findById("8683fad9-eac9-48a2-9304-140ffd723a62"));
            Postazione p3Milano = new Postazione(faker.friends().quote(), PostazioneTipo.SALA_RIUNIONI, edificiService.findById("8683fad9-eac9-48a2-9304-140ffd723a62"));
            Postazione p1Roma = new Postazione(faker.friends().quote(), PostazioneTipo.PRIVATO, edificiService.findById("a64670cf-7e75-4d9e-a009-f50219666bed"));
            Postazione p2Roma = new Postazione(faker.friends().quote(), PostazioneTipo.OPENSPACE, edificiService.findById("a64670cf-7e75-4d9e-a009-f50219666bed"));
            Postazione p3Roma = new Postazione(faker.friends().quote(), PostazioneTipo.SALA_RIUNIONI, edificiService.findById("a64670cf-7e75-4d9e-a009-f50219666bed"));
            postazioniService.save(p1Milano);
            postazioniService.save(p2Milano);
            postazioniService.save(p3Milano);
            postazioniService.save(p1Roma);
            postazioniService.save(p2Roma);
            postazioniService.save(p3Roma);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

        try {
            Prenotazione p = new Prenotazione("2024-09-07", usersService.findById("aabcf500-f11d-46c1-b55b-77c031d43874"), postazioniService.findById("68b5f863-e048-4be5-b1ea-9b1cf2efb1bc"));
            prenotazioniService.save(p);
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }

    }
}
