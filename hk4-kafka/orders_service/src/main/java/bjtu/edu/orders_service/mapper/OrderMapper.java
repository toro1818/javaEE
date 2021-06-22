package bjtu.edu.orders_service.mapper;

import bjtu.edu.orders_service.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;
//import org.springframework.stereotype.Repository;

@Mapper
public interface OrderMapper {
    List<Order> findAllByStateAndUserid(@Param("state")Integer state, @Param("userid")Integer userid);

    int addOne(Order order);

    Order findById(Integer id);

    int deleteOne(Integer id);

    int updateOne(Order order);
}
