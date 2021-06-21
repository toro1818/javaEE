package edu.bjtu.books_service;

import edu.bjtu.books_service.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BooksServiceApplicationTests {

    @Autowired
    BookService bookService;
    @Test
    void contextLoads() {
        System.out.println(bookService.findALL());
    }

}
