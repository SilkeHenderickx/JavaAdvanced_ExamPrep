package edu.ap.ExamenPrep.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    Page<Book> findAllByOnHoldEquals(Integer onHold, Pageable pageable);

    Page<Book> findAll(Pageable pageable);

    Page<Book> findAllByBookCategoryAndOnHoldEquals(BookCategory category, Integer onHold, Pageable pageable);

    Page<Book> findAllByBookCategory(BookCategory category, Pageable pageable);

    int countAllByOnHoldEquals(Integer onHold);

    int countAllByBookCategoryAndOnHoldEquals(BookCategory category, Integer onHold);

    int countAllByBookCategory(BookCategory category);

    Iterable<Book> findAllByOnHoldGreaterThan(Integer integer);

    @Transactional
    Long deleteBookByTitle(String title);

}
