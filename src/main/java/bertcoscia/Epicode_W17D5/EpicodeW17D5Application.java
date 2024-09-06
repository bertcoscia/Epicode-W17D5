package bertcoscia.Epicode_W17D5;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EpicodeW17D5Application {

	static Faker faker = new Faker();

	public static void main(String[] args) {
		SpringApplication.run(EpicodeW17D5Application.class, args);
	}
}
