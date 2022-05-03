package com.ruoyi.greenfarm.persistence;

import com.ruoyi.greenfarm.domain.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO {
    Cart findByCartid(Cart cart);
    List<Cart> getAllCartitem();

}
