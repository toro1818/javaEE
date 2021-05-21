package bjtu.edu.ebookshoprestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication

public class EBookShopRestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBookShopRestfulApplication.class, args);
    }

}
