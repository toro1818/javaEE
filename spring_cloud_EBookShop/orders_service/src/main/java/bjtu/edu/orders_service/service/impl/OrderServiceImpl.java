package bjtu.edu.orders_service.service.impl;

import bjtu.edu.orders_service.entity.Order;
import bjtu.edu.orders_service.mapper.OrderMapper;
import bjtu.edu.orders_service.service.IntegrationService;
import bjtu.edu.orders_service.service.OrderService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IntegrationService integrationService;

    @Override
    public List<Order> findAllUnpaidOrdersByUserid(Integer userid) {
        List<Order> orderList=orderMapper.findAllByStateAndUserid(0,userid);
        for(Order o:orderList){
            o.setBook(integrationService.getBook(o.getBid()));
        }
        return orderList;
    }

    @Override
    public int addOne(Order order) {

        return orderMapper.addOne(order);
    }

    @Override
    public Order findById(Integer id) {
        Order order=orderMapper.findById(id);
        order.setBook(integrationService.getBook(order.getBid()));
        return order;
    }

    @Override
    public int buyConfirm(Order order) {
        order.setState(1);
        return orderMapper.updateOne(order);
    }

    @Override
    public int deleteOne(Integer orderid) {

        return orderMapper.deleteOne(orderid);
    }
}
