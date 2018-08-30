package edu.ap.ExamenPrep;

import edu.ap.ExamenPrep.view.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamenPrepApplication {

	@Autowired
	UI ui;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return (args) -> {
			ui.setupUI();
		};
	}

	public static void main(String[] args) { SpringApplication.run(ExamenPrepApplication.class, args); }

}
