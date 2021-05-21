package bjtu.edu.ebookshoprestful.repository;

import bjtu.edu.ebookshoprestful.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book,Integer> {
    List<Book> findByBooknameLike(String name);
}
