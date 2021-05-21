package bjtu.edu.ebookshoprestful.controller;

import bjtu.edu.ebookshoprestful.entity.Book;
import bjtu.edu.ebookshoprestful.service.IBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "图书管理接口")
//@CrossOrigin
//@CrossOrigin(origins = "*", maxAge = 3600)
public class BookController {
    @Autowired
    private IBookService bookService;

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
