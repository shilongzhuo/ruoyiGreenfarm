package com.ruoyi.greenfarm.persistence;

import com.ruoyi.greenfarm.domain.CartItem;
import com.ruoyi.greenfarm.domain.Farm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FarmDAO {

    void insertFarm(Farm farm);

    void deleteFarm(Farm farm);

    void updateFarm(Farm farm);

    Farm getFarmByFarmid(Farm farm);

    List<Farm> getAllFarm();
}
