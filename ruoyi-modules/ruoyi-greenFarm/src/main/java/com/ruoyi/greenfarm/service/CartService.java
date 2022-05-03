package com.ruoyi.greenfarm.service;

import com.ruoyi.greenfarm.domain.Cart;
import com.ruoyi.greenfarm.domain.Farm;
import com.ruoyi.greenfarm.domain.Item;
import com.ruoyi.greenfarm.persistence.CartDAO;
import com.ruoyi.greenfarm.persistence.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartDAO cartDAO;
    public Cart getCartInfo(Cart cart)
    {
        return cartDAO.findByCartid(cart);
    }
    public List<Cart> getAllCartitem()
    {
        return cartDAO.getAllCartitem();
    }
}
