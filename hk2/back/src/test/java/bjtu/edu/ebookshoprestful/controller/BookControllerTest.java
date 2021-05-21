package bjtu.edu.ebookshoprestful.controller;

import bjtu.edu.ebookshoprestful.entity.Book;
import bjtu.edu.ebookshoprestful.service.IBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookControllerTest {
    @Autowired
    private IBookService bookService;
    private Book book;

    @Autowired
    BookController bookController;

    @Test
    void test(){
        assert (1==1);
    }

    @Test
    void getBooksTest(){
        Book book1=new Book(1,"红楼梦","曹雪芹","小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，以贾宝玉与林黛玉、薛宝钗的爱情婚姻悲剧为主线，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美。",(float)50.56);
        Book book2=new Book(11,"发哥经典","周润发","XXXXXXXXXX",(float)10.0);
        Book book3=new Book(15,"西游记","222","intro",(float)1000.0);

        //List<Book> actual=bookService.findALL();
        List<Book> actual=Arrays.asList(book1,book2,book3);
        actual=bookService.findALL();
        List<Book> expected=bookController.getBooks();
        System.out.println(expected);
        assertTrue(expected.equals(actual));

    }

    @Test
    void getBooksTest1(){
        Book book1=new Book(12,"三国演义","曹雪芹","小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，以贾宝玉与林黛玉、薛宝钗的爱情婚姻悲剧为主线，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美。",(float)50.56);
        Book book2=new Book(11,"发哥经典","周润发","XXXXXXXXXX",(float)10.0);

        //List<Book> actual=bookService.findALL();
        List<Book> actual=Arrays.asList(book1,book2);
        List<Book> expected=bookController.getBooks();
        System.out.println(expected);
        assertTrue(expected.equals(actual));

    }

    @Test
    void getBookTest(){
        Book book1=new Book(1,"红楼梦","曹雪芹","小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，以贾宝玉与林黛玉、薛宝钗的爱情婚姻悲剧为主线，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美。",(float)50.56);
        //Book actual=null;
        Book expected=bookController.getBook(1);
        System.out.println(expected);
        assertTrue(expected.equals(book1));
    }

    @Test
    void getBookTest1(){
        Book book1=new Book(1,"三国演义","曹雪芹","小说以贾、史、王、薛四大家族的兴衰为背景，以富贵公子贾宝玉为视角，以贾宝玉与林黛玉、薛宝钗的爱情婚姻悲剧为主线，描绘了一批举止见识出于须眉之上的闺阁佳人的人生百态，展现了真正的人性美和悲剧美。",(float)50.56);
        //Book actual=null;
        Book expected=bookController.getBook(1);
        System.out.println(expected);
        assertTrue(expected.equals(book1));
    }

    @Test
    void addBookTest(){
        Book add=new Book("西游记","111","intro",(float)1000.0);
        bookController.addBook(add);
        Book actual=add;
        Book expected=bookController.getBook(17);
        assertTrue(expected.equals(actual));
    }

    @Test
    void modifyBookTest(){
       Book modify=new Book(15,"东游记","222","intro",(float)1000.0);
       bookController.modifyBook(modify);

        Book expected=bookController.getBook(15);
        assertTrue(expected.equals(modify));
    }


    @Test
    void deleteBookTest(){
        bookController.deleteBook(11);
        assert(bookController.getBook(11)==null);
    }

    @Test
    void searchBookTest(){
        Book book1=new Book(15,"东游记","222","intro",(float)1000.0);
        List<Book> actual=Arrays.asList(book1);
        List<Book> expected=bookController.searchBooks("东");
        assertTrue(expected.equals(actual));
    }
}