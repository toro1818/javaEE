package bjtu.ebookshop.service;

import bjtu.ebookshop.entity.Book;
import bjtu.ebookshop.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService{

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public List<Book> findALL() {
        return booksRepository.findAll();
    }

    @Override
    public Book findOne(Integer id) {
        return booksRepository.findById(id).orElse(null);
    }

    @Override
    public Book insert(Book b) {
        return booksRepository.save(b);
    }

    @Override
    public Book update(Book b) {
        return booksRepository.save(b);
    }

    @Override
    public void delete(Integer id) {
        booksRepository.deleteById(id);
    }
}
