package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@SpringBootApplication
@EnableJpaRepositories("tn.esprit.spring.Repository")
@EntityScan( basePackages = {"tn.esprit.spring.Entity"})
public class DariTnApplication {

	public static void main(String[] args) {
		SpringApplication.run(DariTnApplication.class, args);
	}

}
