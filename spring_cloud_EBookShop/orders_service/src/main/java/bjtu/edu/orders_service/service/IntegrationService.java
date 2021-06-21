package bjtu.edu.orders_service.service;

import bjtu.edu.orders_service.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegrationService {
    @Autowired
    private BooksServiceFeign booksServiceFeign;

    public String getTest(){
        return booksServiceFeign.test();
    }

    public List<Book> getBooks(){ return booksServiceFeign.getBooks(); }

    public Book getBook(Integer id){return booksServiceFeign.getBook(id);}

    public void modifyBook(Book book){ booksServiceFeign.modifyBook(book);}
}
