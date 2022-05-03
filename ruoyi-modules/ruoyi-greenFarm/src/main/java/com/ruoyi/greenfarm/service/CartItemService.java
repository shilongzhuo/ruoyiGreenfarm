package com.ruoyi.greenfarm.service;

import com.ruoyi.greenfarm.domain.CartItem;
import com.ruoyi.greenfarm.persistence.CartItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemService {
    @Autowired
    private CartItemDAO cartItemDAO;
    //向购物车中插入单个商品
    @Transactional
    public void insertCartItem(CartItem cartItem){
//        CartItem cartItem = cartItemDAO.getCartItemByUsernameAndItemId(username, cartItemId);
//        if(cartItem != null){
//            cartItemDAO.updateCartItem(username,cartItemId,cartItem.getQuality()+1);
//        }else{
//            cartItemDAO.insertCartItem(username,cartItemId);
//        }
        cartItemDAO.insertCartItem(cartItem);
    }
    @Transactional
    public void deleteCartItem(CartItem cartItem)
    {
        cartItemDAO.deleteCartItem(cartItem);
    }
    @Transactional
    public void updateCartItem(CartItem cartItem)
    {
        cartItemDAO.updateCartItem(cartItem);
    }
    public CartItem getCartItem(CartItem cartItem)
    {
        return cartItemDAO.getCartItem(cartItem);
    }
}
