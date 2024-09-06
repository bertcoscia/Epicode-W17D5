package bertcoscia.Epicode_W17D5;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Locale;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    Faker faker = new Faker(Locale.ITALY);
    @Bean(name = "edificio_roma")
    public Edificio edificioRomaBean() { return new Edificio("Roma - Colosseo", "Roma", faker.address().fullAddress()); }

    @Bean(name = "edificio_milano")
    public Edificio edificioMilanoBean() { return new Edificio("Milano - Porta Nuova", "Milano", faker.address().fullAddress()); }

}
