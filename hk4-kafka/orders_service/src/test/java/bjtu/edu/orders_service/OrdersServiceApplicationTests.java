package bjtu.edu.orders_service;

import bjtu.edu.orders_service.entity.Book;
import bjtu.edu.orders_service.entity.Order;
import bjtu.edu.orders_service.entity.User;
import bjtu.edu.orders_service.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class OrdersServiceApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("初始化");
    }
    @Autowired
    OrderServiceImpl orderService;

    @Test
    void testFindUnpaid(){
        System.out.println(orderService.findAllUnpaidOrdersByUserid(1));
    }
    @Test
    void testFindById(){
        System.out.println(orderService.findById(2));
    }
    @Test
    void testAddOrder() {
        Order order=new Order();
        Book book=new Book(1,"西游记","吴承恩",10,"西游取经", (float) 19.9);
        User user =new User(1,"123456","180");
        order.setBook(book);
        order.setUser(user);
        order.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        orderService.addOne(order);
    }

    @Test
    void testBuyConfirm(){
        Order order= orderService.findById(2);
        orderService.buyConfirm(order);
    }

    @Test
    void testDelete(){
        System.out.println(orderService.deleteOne(5));
    }



}
