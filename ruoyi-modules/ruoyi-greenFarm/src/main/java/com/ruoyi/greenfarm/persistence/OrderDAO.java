package com.ruoyi.greenfarm.persistence;

import com.ruoyi.greenfarm.domain.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO {
    Orders findOrder(Orders orders);
    void insertOrder(Orders orders);
    void deleteOrder(Orders orders);
    void insertOrderitem(Orders orders);
    void deleteOrderitem(Orders orders);
    void insertOrderstatus(Orders orders);
    void deleteOrderstatus(Orders orders);
    List<Orders> findAllOrder();
}
