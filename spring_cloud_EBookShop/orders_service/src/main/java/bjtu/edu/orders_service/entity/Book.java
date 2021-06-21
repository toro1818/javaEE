package bjtu.edu.orders_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Book {
    private Integer id;

    private String bookname;

    private String author;

    private Integer count;

    private String intro;

    private Float price;
}
