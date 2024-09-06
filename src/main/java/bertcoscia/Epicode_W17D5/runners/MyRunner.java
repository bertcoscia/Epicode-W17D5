package bertcoscia.Epicode_W17D5.runners;

import bertcoscia.Epicode_W17D5.services.EdificiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    EdificiService edificiService;

    @Autowired
    AnnotationConfigApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

    }
}
