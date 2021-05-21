package bjtu.ebookshop.repository;

import bjtu.ebookshop.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BooksRepository extends JpaRepository<Book, Integer> {
}
