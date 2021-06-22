package edu.bjtu.books_service.controller;

import edu.bjtu.books_service.entity.Book;
import edu.bjtu.books_service.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="Book Controller")
@RestController
public class BooksController {
    @Autowired
    BookService bookService;

    @GetMapping("/books/test")
    public String test(){
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "books_service test";
    }

    @GetMapping("/books")
    @ApiOperation("获得图书列表")
    public List<Book> getBooks(){
        List<Book> bookList=bookService.findALL();
        return bookList;
    }

    @GetMapping("/books/{id}")
    @ApiOperation("获得指定图书")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Book getBook(@PathVariable("id") Integer id){
        Book book=bookService.findOne(id);
        return book;
    }


    @PostMapping("/books")
    @ApiOperation("新增图书")
    public void addBook(@RequestBody Book book){
        Book book1=  book;
        bookService.insert(book1);
    }

    @PutMapping("/books")
    @ApiOperation("修改图书信息")
    public void modifyBook(@RequestBody Book book){
        Book book1=  book;
        bookService.update(book1);
    }

    @DeleteMapping("/books/{id}")
    @ApiOperation("删除指定图书")
    public void deleteBook(@PathVariable("id") Integer id){
        bookService.delete(id);
    }

    @GetMapping("/books/searchResult/{searchKey}")
    @ApiOperation("图书模糊查询")
    public List<Book> searchBooks(@PathVariable("searchKey") String searchKey){
        System.out.println(searchKey);
        List<Book> bookList=bookService.findByNameLike("%"+searchKey+"%");
        return bookList;
    }
}
