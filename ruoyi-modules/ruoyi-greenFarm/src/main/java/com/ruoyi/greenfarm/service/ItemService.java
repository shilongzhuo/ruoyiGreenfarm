package com.ruoyi.greenfarm.service;

import com.ruoyi.greenfarm.domain.Item;
import com.ruoyi.greenfarm.persistence.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemDAO itemDAO;
    public Item getInfo(Item item)
    {
        return itemDAO.findByItemid(item);
    }
    public void insertItem(Item item)
    {
        itemDAO.insertItem(item);
    }
    public void deleteItem(Item item)
    {
        itemDAO.deleteItem(item);
    }
    public void updateItem(Item item)
    {
        itemDAO.updateItem(item);
    }
    public List<Item> findAllItem()
    {
        return itemDAO.findAllItem(); 
    }
}
