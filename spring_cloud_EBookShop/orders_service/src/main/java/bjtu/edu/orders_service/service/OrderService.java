package bjtu.edu.orders_service.service;


import bjtu.edu.orders_service.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAllUnpaidOrdersByUserid(Integer userid);

    int addOne(Order order);

    Order findById(Integer orderid);

    int buyConfirm(Order order);

    int deleteOne(Integer orderid);
}
