package edu.ap.ExamenPrep.persistence;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "onHold")
    private Integer onHold;

    @Column(name = "bookCategory")
    private String bookCategory;

    public Book(String title, String author, BookCategory bookCategory) {
        this.title = title;
        this.author = author;
        this.bookCategory = bookCategory.toString();
        this.onHold = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getOnHold() {
        return onHold;
    }

    public void setOnHold(Integer onHold) {
        this.onHold = onHold;
    }

    public String getBookCategory() {
        return bookCategory.toString();
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory.toString();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", onHold=" + onHold +
                ", bookCategory=" + bookCategory +
                '}';
    }
}
