package edu.ap.ExamenPrep.view;

import edu.ap.ExamenPrep.model.BookRecommender;
import edu.ap.ExamenPrep.persistence.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;

@Component
public class EventHandler {

    private UI ui;
    private BookRecommender bookRecommender;

    @Autowired
    public void setUI(UI ui) {
        this.ui = ui;
    }

    @Autowired
    public void setEightBall(BookRecommender bookRecommender) {
        this.bookRecommender = bookRecommender;
    }

    public void whenAddButtonClicked(ActionEvent actionEvent){

        String title = ui.getTFTitle().getText();
        String author = ui.getTFAuthor().getText();
        BookCategory category = (BookCategory)ui.getDCategory().getSelectedItem();

        bookRecommender.AddBook(title, author, category);

    }

    public void whenDeleteButtonClicked(ActionEvent actionEvent){
        String title = ui.getTFTitle().getText();
        bookRecommender.DeleteBook(title);
    }

}
