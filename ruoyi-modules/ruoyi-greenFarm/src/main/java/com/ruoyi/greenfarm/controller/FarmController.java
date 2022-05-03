package com.ruoyi.greenfarm.controller;

import com.ruoyi.greenfarm.domain.Farm;
import com.ruoyi.greenfarm.domain.Item;
import com.ruoyi.greenfarm.service.FarmService;
import com.ruoyi.greenfarm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/farm")
public class FarmController {
    @Autowired
    private FarmService farmService;

    @GetMapping("/getall")
    @ResponseBody
    public List<Farm> getall()
    {
        return farmService.getAllFarm();
    }
}
