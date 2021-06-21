package edu.bjtu.books_service.service;


import edu.bjtu.books_service.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findALL();

    Book findOne(Integer id);

    List<Book> findByNameLike(String key);

    Book insert(Book b);

    Book update(Book b);

    void delete(Integer id);
}
