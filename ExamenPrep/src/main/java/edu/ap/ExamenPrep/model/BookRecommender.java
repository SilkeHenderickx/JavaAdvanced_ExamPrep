package edu.ap.ExamenPrep.model;

import edu.ap.ExamenPrep.persistence.Book;
import edu.ap.ExamenPrep.persistence.BookCategory;
import edu.ap.ExamenPrep.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class BookRecommender {

    private BookRepository repository;

    @Autowired
    public void setQuestionRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void AddBook(Book book){
        repository.save(book);
    }

    public void DeleteBook(Book book){
        repository.delete(book);
    }

    public Book RecommendBook(BookCategory category){

        long qty;
        int idx;
        Page<Book> bookPage;

        if (category == null) {
            qty =repository.count();
            idx = (int)(Math.random() * qty);
            bookPage = repository.findAll(PageRequest.of(idx, 1));
        }
        else{
            qty =repository.countAllByBookCategory(category);
            idx = (int)(Math.random() * qty);
            bookPage = repository.findAllByBookCategory(category,PageRequest.of(idx, 1));
        }

        Book b = null;
        if (bookPage.hasContent()) {
            b = bookPage.getContent().get(0);
        }

        //TODO SetBookOnHold(b);

        return b;
    }

}
