package com.ruoyi.greenfarm.controller;

import com.ruoyi.greenfarm.domain.Item;
import com.ruoyi.greenfarm.domain.Orders;
import com.ruoyi.greenfarm.service.ItemService;
import com.ruoyi.greenfarm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getall")
    @ResponseBody
    public List<Orders>all()
    {
        return orderService.findAllOrder();
    }
}
