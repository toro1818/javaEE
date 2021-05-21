package bjtu.ebookshop.service;

import bjtu.ebookshop.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Resource
    private BookService bookService;

    @Test
    void findALL() {
        List<Book> list =new LinkedList<>();
        list=this.bookService.findALL();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        assertNotNull(list);

    }

    @Test
    void findOne() {
        Book book=new Book();

        book=this.bookService.findOne(1);
        System.out.println(book);
        assertNotNull(book);
    }


    @Test
    //@Transactional
    //@Rollback
    void insert() {
        Book book=new Book();
        book.setBookname("book1");
        book.setAuthor("Author1");
        book.setIntro("用于插入");
        book.setPrice((float)50.0);
        this.bookService.insert(book);
    }

    @Test
    void update() {
        Book book=new Book();
        book=this.bookService.findOne(10);
        book.setIntro("用于更新");
        this.bookService.update(book);

    }

    @Test
    void delete() {

        this.bookService.delete(11);

    }
}