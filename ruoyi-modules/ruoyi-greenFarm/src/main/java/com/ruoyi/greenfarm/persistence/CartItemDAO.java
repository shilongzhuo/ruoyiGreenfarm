package com.ruoyi.greenfarm.persistence;

import com.ruoyi.greenfarm.domain.CartItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDAO {

    void insertCartItem(CartItem cartItem);

    void deleteCartItem(CartItem cartItem);

    void updateCartItem(CartItem cartItem);

    List<String> getCartItemIdByUsername(String username);

    CartItem getCartItem(CartItem cartItem);

}
