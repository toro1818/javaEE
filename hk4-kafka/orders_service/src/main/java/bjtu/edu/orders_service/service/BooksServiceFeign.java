package bjtu.edu.orders_service.service;

import bjtu.edu.orders_service.entity.Book;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("BOOKS-SERVICE")
public interface BooksServiceFeign {
    @GetMapping("books/test")
    String test();

    @GetMapping("books")
    List<Book> getBooks();

    @GetMapping("books/{id}")
    Book getBook(@PathVariable("id") Integer id);

    @PutMapping("books")
    void modifyBook(@RequestBody Book book);


}
