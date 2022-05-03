package com.ruoyi.greenfarm.service;

import com.ruoyi.greenfarm.domain.Cart;
import com.ruoyi.greenfarm.domain.CartItem;
import com.ruoyi.greenfarm.domain.Farm;
import com.ruoyi.greenfarm.persistence.CartDAO;
import com.ruoyi.greenfarm.persistence.FarmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService
{
    @Autowired
    private FarmDAO farmDAO;
    public void insertFarm(Farm farm)
    {
        farmDAO.insertFarm(farm);
    }
    public void deleteFarm(Farm farm)
    {
        farmDAO.deleteFarm(farm);
    }

    public void updateFarm(Farm farm)
    {
        farmDAO.updateFarm(farm);
    }

    public Farm getFarmByFarmid(Farm farm)
    {
        return farmDAO.getFarmByFarmid(farm);
    }
    public List<Farm> getAllFarm()
    {
        return farmDAO.getAllFarm();
    }

}
