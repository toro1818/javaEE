package edu.bjtu.books_service.repository;

import edu.bjtu.books_service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByBooknameLike(String name);
}
