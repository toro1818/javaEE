package bjtu.edu.orders_service.entity;

import lombok.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@AllArgsConstructor
@Getter @Setter
public class Order implements Serializable {

    private Integer id;

    private User user;

    private Integer uid;

    private Book book;

    private Integer bid;

    private String date;

//    0 未付款  1 已付款
    private Integer state;

    public Order(){
        this.date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
