package edu.ap.ExamenPrep.view;

import edu.ap.ExamenPrep.model.BookRecommender;
import edu.ap.ExamenPrep.persistence.Book;
import edu.ap.ExamenPrep.persistence.BookCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;

@Component
public class EventHandler {

    private UI ui;
    private BookRecommender bookRecommender;
    private Book book;

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

        bookRecommender.addBook(title, author, category);

    }

    public void whenDeleteButtonClicked(ActionEvent actionEvent){
        String title = ui.getTFTitle().getText();
        bookRecommender.deleteBook(title);
    }

    public void whenRecommendButtonClicked(ActionEvent actionEvent){

        BookCategory category = null;

        if (ui.jRadioButtonFiction.isSelected()){
            category = BookCategory.FICTION;
        }
        else if (ui.jRadioButtonNonFiction.isSelected()){
            category = BookCategory.NONFICTION;
        }
        Book b = bookRecommender.recommendBook(category);

        JOptionPane.showMessageDialog(null, b.toString(), "InfoBox: " + "We recommend reading:", JOptionPane.INFORMATION_MESSAGE);

    }

}
