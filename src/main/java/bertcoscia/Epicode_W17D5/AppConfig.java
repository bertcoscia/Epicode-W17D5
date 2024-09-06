package bertcoscia.Epicode_W17D5;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import bertcoscia.Epicode_W17D5.exceptions.NotFoundException;
import bertcoscia.Epicode_W17D5.exceptions.ValidationException;
import bertcoscia.Epicode_W17D5.repositories.PostazioniRepository;
import bertcoscia.Epicode_W17D5.services.EdificiService;
import bertcoscia.Epicode_W17D5.services.PostazioniService;
import bertcoscia.Epicode_W17D5.services.PrenotazioniService;
import bertcoscia.Epicode_W17D5.services.UsersService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
}
