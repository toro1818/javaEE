package bjtu.edu.ebookshoprestful.service;

import bjtu.edu.ebookshoprestful.entity.Book;
import bjtu.edu.ebookshoprestful.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Book> findByNameLike(String key) {
        return booksRepository.findByBooknameLike(key);
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
