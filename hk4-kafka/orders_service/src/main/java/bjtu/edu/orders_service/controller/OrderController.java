package bjtu.edu.orders_service.controller;

//import org.springframework.stereotype.Controller;
import bjtu.edu.orders_service.entity.Order;
import bjtu.edu.orders_service.entity.User;
import bjtu.edu.orders_service.service.IntegrationService;
import bjtu.edu.orders_service.service.impl.OrderServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import bjtu.edu.orders_service.controller.CreateOrderRequestDTO;

@RestController
public class OrderController {

    @Autowired
    IntegrationService integrationService;
    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/orders/test1")
    public String test(){
        return integrationService.getTest();
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody CreateOrderRequestDTO requestDTO){
        Order order=new Order();
        System.out.println(requestDTO.getUid());
        User user=new User();
        user.setId(requestDTO.getUid());
        order.setUser(user);
        order.setBook(integrationService.getBook(requestDTO.getBid()));
        orderService.addOne(order);
        return "新增订单成功";
    }

    @GetMapping("/orders/unpaid")
    public List<OrderResponseDTO> getAllOrdersUnpaid(@RequestParam("uid") Integer uid){
        List<Order> orderList=orderService.findAllUnpaidOrdersByUserid(uid);
        List<OrderResponseDTO> responseDTOList=new ArrayList<>();
        for (Order o:orderList){
            OrderResponseDTO temp=new OrderResponseDTO(o.getId(),o.getBid(),
                    o.getUid(),o.getBook(),o.getDate(),o.getState());
            responseDTOList.add(temp);
        }
        return responseDTOList;
    }

    @DeleteMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Integer id){
        if(orderService.findById(id)!=null){
            orderService.deleteOne(id);
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @GetMapping("/orders/{id}")
    public OrderResponseDTO getOrder(@PathVariable Integer id){
        Order order=orderService.findById(id);
        OrderResponseDTO orderResponseDTO=new OrderResponseDTO(order.getId(),order.getBid(),
                order.getUid(),order.getBook(),order.getDate(),order.getState());
        return orderResponseDTO;
    }

    @PutMapping("/orders/buy")
    public String ordersBuy(@RequestBody List<Order> orderList){
        for(Order order:orderList){
            orderService.buyConfirm(order);
            System.out.println(123);
        }
        return "购买成功";
    }
}
