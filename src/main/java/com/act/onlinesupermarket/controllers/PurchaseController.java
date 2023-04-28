package com.act.onlinesupermarket.controllers;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Purchase;
import com.act.onlinesupermarket.dto.PurchaseRequest;
import com.act.onlinesupermarket.services.AccountService;
import com.act.onlinesupermarket.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/api/purchase")
    public ResponseEntity<?> purchase(@RequestBody PurchaseRequest purchaseRequest){

        try{
            Purchase purchase= purchaseService.purchaseItem(purchaseRequest);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(purchase);
        }
        catch(Exception ex){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\":"+ex.getMessage()+"}");

        }

            }
    @GetMapping("/api/purchase")
    public Iterable<Purchase> getAllPurchase(){
        return purchaseService.getAllPurchase();
    }

}
