package bjtu.edu.ebookshoprestful.controller;

import bjtu.edu.ebookshoprestful.entity.Book;
import bjtu.edu.ebookshoprestful.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin
//@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public List<Book> getBooks(){
        List<Book> bookList=bookService.findALL();
        return bookList;
    }

    @GetMapping("/books/{id}")
//    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public Book getBook(@PathVariable("id") Integer id){
        Book book=bookService.findOne(id);
        return book;
    }


    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        Book book1=  book;
        bookService.insert(book1);
    }

    @PutMapping("/books")
    public void modifyBook(@RequestBody Book book){
        Book book1=  book;
        bookService.update(book1);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") Integer id){
        bookService.delete(id);
    }

    @GetMapping("/books/searchResult/{searchKey}")
    public List<Book> searchBooks(@PathVariable("searchKey") String searchKey){
        System.out.println(searchKey);
        List<Book> bookList=bookService.findByNameLike("%"+searchKey+"%");
        return bookList;
    }

}
