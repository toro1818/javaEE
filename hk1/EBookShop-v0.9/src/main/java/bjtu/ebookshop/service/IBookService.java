package bjtu.ebookshop.service;

import bjtu.ebookshop.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {

    List<Book> findALL();

    Book findOne(Integer id);

    Book insert(Book b);

    Book update(Book b);

    void delete(Integer id);

}
