package com.ruoyi.greenfarm.persistence;

import com.ruoyi.greenfarm.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDAO {
    Item findByItemid(Item item);
    void insertItem(Item item);
    void deleteItem(Item item);
    void updateItem(Item item);
    List<Item> findAllItem();
}
