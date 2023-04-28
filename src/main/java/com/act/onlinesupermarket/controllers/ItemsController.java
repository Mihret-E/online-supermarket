package com.act.onlinesupermarket.controllers;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Items;
import com.act.onlinesupermarket.services.AccountService;
import com.act.onlinesupermarket.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class ItemsController {

    @Autowired
    ItemService itemService;

    @PostMapping("/api/items")
    public Items createItem(@RequestBody Items items){


        return itemService.registerItem(items);
    }
    @GetMapping("/api/items")
    public Iterable<Items> getAllAccount(){
        return itemService.getAllItems();
    }

}
