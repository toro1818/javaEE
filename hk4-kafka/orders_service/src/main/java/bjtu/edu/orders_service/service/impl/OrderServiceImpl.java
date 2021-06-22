package bjtu.edu.orders_service.service.impl;

import bjtu.edu.orders_service.entity.Order;
import bjtu.edu.orders_service.mapper.OrderMapper;
import bjtu.edu.orders_service.service.IntegrationService;
import bjtu.edu.orders_service.service.OrderService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${spring.kafka.topics.delivery}")
    private String deliverName;

    @Value("${spring.kafka.topics.pay}")
    private String payName;

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
        this.kafkaTemplate.send(deliverName,order);
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
        this.kafkaTemplate.send(payName,order);
        return orderMapper.updateOne(order);
    }

    @Override
    public int deleteOne(Integer orderid) {
        return orderMapper.deleteOne(orderid);
    }

    @KafkaListener(topics = "${spring.kafka.topics.order}", groupId = "${spring.kafka.consumer.group-id}")
    public void getresult(Order order){
        System.out.println(order.getid()+"操作完成");
    }
}
