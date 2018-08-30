package edu.ap.ExamenPrep.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    Page<Book> findAll(Pageable pageable);

    Page<Book> findAllByBookCategory(BookCategory category, Pageable pageable);

    int countAllByBookCategory(BookCategory category);

}
