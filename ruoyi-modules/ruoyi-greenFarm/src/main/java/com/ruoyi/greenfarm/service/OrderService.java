package com.ruoyi.greenfarm.service;

import com.ruoyi.greenfarm.domain.Orders;
import com.ruoyi.greenfarm.persistence.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;
    public void insertOrder(Orders orders)
    {
        orderDAO.insertOrder(orders);
    }
    public void deleteOrder(Orders orders)
    {
        orderDAO.deleteOrder(orders);
    }

    public Orders findOrder(Orders orders)
    {
        return orderDAO.findOrder(orders);
    }

    public void insertOrderitem(Orders orders)
    {
        orderDAO.insertOrderitem(orders);
    }
    public void deleteOrderitem(Orders orders)
    {
        orderDAO.deleteOrderitem(orders);
    }
    public void insertOrderstatus(Orders orders)
    {
        orderDAO.insertOrderstatus(orders);
    }
    public void deleteOrderstatus(Orders orders)
    {
        orderDAO.deleteOrderstatus(orders);
    }
    public List<Orders> findAllOrder()
    {
        return orderDAO.findAllOrder();
    }
}
