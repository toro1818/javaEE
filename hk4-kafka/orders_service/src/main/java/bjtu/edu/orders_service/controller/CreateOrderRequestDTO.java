package bjtu.edu.orders_service.controller;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateOrderRequestDTO {
    private Integer bid;
    private Integer uid;
}
