package com.ruoyi.greenfarm.controller;

import com.ruoyi.greenfarm.domain.Cart;
import com.ruoyi.greenfarm.domain.CartItem;
import com.ruoyi.greenfarm.domain.Farm;
import com.ruoyi.greenfarm.service.CartItemService;
import com.ruoyi.greenfarm.service.CartService;
import com.ruoyi.greenfarm.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cartitem")
public class CartitemController {
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private FarmService farmService;

    @RequestMapping("/getall")
    @ResponseBody
    public List<Cart> getall()
    {
//        CartItem cartItem = new CartItem();
//        cartItem.setCartid("gwc-1");
//        cartItem.setCustomeid("cus-1");
//        cartItem.setItemid("itemid");
//        cartItem.setNumber(1);
//        cartItemService.insertCartItem(cartItem);

//        Farm farm = new Farm();
//        farm.setAddress("11");
//        farm.setF_id("F-1");
//        farm.setName("11");
//        farm.setFarmid("FA-1");
//        farm.setSrc("//");
//        farm.setPrice(1);
//        farm.setStatus(1);
//        farm.setUserid("U-1");
//        farmService.insertFarm(farm);
        return cartService.getAllCartitem();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public List<Cart> addcart(@RequestBody Map<String, Object> map)
    {

        CartItem cartItem = new CartItem();
        cartItem.setCartid("gwc-1");
        cartItem.setCustomeid("cus-1");
        cartItem.setItemid((String)map.get("itemid"));
        cartItem.setNumber(1);
        cartItemService.insertCartItem(cartItem);
        return cartService.getAllCartitem();

    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    @ResponseBody
    public List<Cart> delcart(@RequestBody Map<String, Object> map)
    {
        CartItem cartItem = new CartItem();
        cartItem.setItemid((String)map.get("itemid"));
        cartItem.setCartid((String)map.get("cartid"));
        System.out.println(cartItem.getItemid()+">>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(cartItem.getCartid()+">>>>>>>>>>>>>>>>>>>>>>>>");
        cartItemService.deleteCartItem(cartItem);
        return cartService.getAllCartitem();
    }
}
