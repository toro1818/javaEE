package bjtu.edu.orders_service.controller;

import bjtu.edu.orders_service.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponseDTO {
    private Integer id;
    private Integer bid;
    private Integer uid;
    private Book book;
    private String date;
    private Integer state;

}
