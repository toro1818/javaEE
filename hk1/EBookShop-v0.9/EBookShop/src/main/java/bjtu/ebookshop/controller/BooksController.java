package bjtu.ebookshop.controller;

import bjtu.ebookshop.entity.Book;
import bjtu.ebookshop.entity.Person;
import bjtu.ebookshop.service.IBookService;
import bjtu.ebookshop.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BooksController {

    @Autowired
    private IBookService bookService;

    @GetMapping(value = "/bookList")
    public String books(Model model){
        List<Book> bookList=bookService.findALL();
        model.addAttribute("bookList",bookList);
        model.addAttribute("count",bookList.size());
        return "bookList";
    }

    @ResponseBody
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.findOne(id);
    }

    @GetMapping(value = "/bookList/add")
    public String showAddBook(Model model){
        Book book=new Book();
        model.addAttribute("book",book);
        return "insert";
    }

    @PostMapping(value = "/bookList/add")
    public String addBook(Model model, Book book){
        System.out.println(book);
        Book newBook=bookService.insert(book);
        return "redirect:/bookList";
    }

    @GetMapping(value = "/book/{id}/edit")
    public String showEditBook(@PathVariable("id") Integer id,Model model){
        System.out.println(id);
        Book book=bookService.findOne(id);
        model.addAttribute("book", book);
        return "edit";
    }

    @PostMapping(value = "/book/{id}/edit")
    public String editBook(@PathVariable("id") Integer id,@ModelAttribute("book") Book book){
        System.out.println(id);
        book.setId(id);
        bookService.update(book);
        return "redirect:/bookList";
    }

    @GetMapping(value = "/book/{id}/delete")
    public String deleteBook(@PathVariable("id") Integer id){
        System.out.println(id);
        bookService.delete(id);
        return "redirect:/bookList";
    }
}
