package edu.ap.ExamenPrep;

import edu.ap.ExamenPrep.model.BookRecommender;
import edu.ap.ExamenPrep.persistence.BookCategory;
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

	public static void main(String[] args) {
		SpringApplication.run(ExamenPrepApplication.class, args);

			BookRecommender r = new BookRecommender();

			r.AddBook("Harry Potter and the Chamber of Secrets", "Rowling", BookCategory.FICTION);
			r.AddBook("The Subtle Art of Not Giving a Fuck", "Manson", BookCategory.NONFICTION);
			r.AddBook("The Gift", "Croggon", BookCategory.FICTION);
			r.AddBook("Baking", "someChef", BookCategory.NONFICTION);

			System.out.println(r.RecommendBook(null).getTitle());
			System.out.println(r.RecommendBook(null).getTitle());
			System.out.println(r.RecommendBook(null).getTitle());
			System.out.println(r.RecommendBook(null).getTitle());
			System.out.println(r.RecommendBook(null).getTitle());
		}

}
