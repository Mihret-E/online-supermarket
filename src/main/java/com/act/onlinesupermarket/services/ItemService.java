package com.act.onlinesupermarket.services;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Items;
import com.act.onlinesupermarket.repositories.AccountRepository;
import com.act.onlinesupermarket.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemsRepository itemsRepository;

    public Items registerItem (Items items){
        return itemsRepository.save(items);

    }
    public Iterable<Items> getAllItems(){

        return itemsRepository.findAll();
    }

}
