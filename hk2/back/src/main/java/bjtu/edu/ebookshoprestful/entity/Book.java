package bjtu.edu.ebookshoprestful.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "author")
    private String author;

    public Book() {
    }

    public Book(Integer id, String bookname, String author, String intro, Float price) {
        this.id = id;
        this.bookname = bookname;
        this.author = author;
        this.intro = intro;
        this.price = price;
    }

    public Book(String bookname, String author, String intro, Float price) {
        this.bookname = bookname;
        this.author = author;
        this.intro = intro;
        this.price = price;
    }

    @Column(name="intro")
    private String intro;
    @Column(name="price")
    private Float price;

}
