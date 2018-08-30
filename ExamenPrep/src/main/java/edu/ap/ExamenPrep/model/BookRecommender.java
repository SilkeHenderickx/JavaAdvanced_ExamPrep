package edu.ap.ExamenPrep.model;

import edu.ap.ExamenPrep.persistence.Book;
import edu.ap.ExamenPrep.persistence.BookCategory;
import edu.ap.ExamenPrep.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.stream.StreamSupport;

@Component
public class BookRecommender {

    @Autowired
    private BookRepository repository;

    @Autowired
    public void setBookRepository(BookRepository repository) {
        this.repository = repository;
    }

    public BookRepository getRepository() {
        return repository;
    }

    public void addBook(String title, String author, BookCategory category){
        repository.save(new Book(title, author,category));
    }

    public void deleteBook(String title){
        repository.deleteBookByTitle(title);
    }

    public Book recommendBook(BookCategory category){

        long qty = 0;
        int idx = 0;
        Page<Book> bookPage;

        if (category == null) {
            qty =repository.countAllByOnHoldEquals(0);
            if ( qty > 0) {
                idx = (int) (Math.random() * qty);
                bookPage = repository.findAllByOnHoldEquals(0, PageRequest.of(idx, 1));
            }
            else{
                qty = repository.count();
                idx = (int) (Math.random() * qty);
                bookPage = repository.findAll(PageRequest.of(idx, 1));
                JOptionPane.showMessageDialog(null, "You have less than 3 books.", "InfoBox: " + "  ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            qty =repository.countAllByBookCategoryAndOnHoldEquals(category, 0);
            if ( qty > 0) {
                idx = (int)(Math.random() * qty);
                bookPage = repository.findAllByBookCategoryAndOnHoldEquals(category, 0,PageRequest.of(idx, 1));
            }
            else{
                qty = repository.countAllByBookCategory(category);
                idx = (int) (Math.random() * qty);
                bookPage = repository.findAllByBookCategory(category, PageRequest.of(idx, 1));
                JOptionPane.showMessageDialog(null, "You have less than 3 books in this category.", "InfoBox: " + "  ", JOptionPane.INFORMATION_MESSAGE);
            }

        }

        Book b = null;
        if (bookPage.hasContent()) {
            b = bookPage.getContent().get(0);
            setBookOnHold(b);
        }
        else{
            JOptionPane.showMessageDialog(null, "You have no books, maybe go buy some more.", "InfoBox: " + "  ", JOptionPane.INFORMATION_MESSAGE);

        }


        return b;
    }

    private void setBookOnHold(Book b){
        b.setOnHold(3);
        repository.save(b);

        Iterable<Book> books = repository.findAllByOnHoldGreaterThan(0);
        StreamSupport.stream(books.spliterator(), false).forEach(s ->s.setOnHold(s.getOnHold()-1));

        repository.saveAll(books);
    }

}
