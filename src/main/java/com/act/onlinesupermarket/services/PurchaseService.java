package com.act.onlinesupermarket.services;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Items;
import com.act.onlinesupermarket.domains.Purchase;
import com.act.onlinesupermarket.dto.PurchaseRequest;
import com.act.onlinesupermarket.repositories.AccountRepository;
import com.act.onlinesupermarket.repositories.ItemsRepository;
import com.act.onlinesupermarket.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    private AccountRepository accountRepository;
   // private AccountRepository accountRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ItemsRepository itemsRepository;



    public Purchase purchaseItem(PurchaseRequest purchaseRequest) throws Exception {
       if (purchaseRequest.getCustId()==null){
            throw new Exception("Customer Id must not be Null");
        }
        if (purchaseRequest.getItemsId()==null){
            throw new Exception("Items Id must not be Null");
        }
        Account customer = accountRepository.findById(purchaseRequest.getCustId()).get();
        Items items = itemsRepository.findById(purchaseRequest.getItemsId()).get();

        Double totalPrice = purchaseRequest.getQuantity()* purchaseRequest.getItemPrice();

        if(purchaseRequest.getCustomerBalance() < totalPrice){
            throw new Exception("Insufficent Balance");
        }
        Double newCustBalance = purchaseRequest.getCustomerBalance() - purchaseRequest.getTotalPrice();
        purchaseRequest.setCustomerBalance(newCustBalance);
       // accountRepository.save(customer);

        Purchase purchase = Purchase.builder()
                .customer(customer)
                .items(items)
                .itemPrice(purchaseRequest.getItemPrice())
                .quantity(purchaseRequest.getQuantity())
                .itemName(purchaseRequest.getItemName())
                .totalPrice(purchaseRequest.getTotalPrice())
                .purchaseDate(purchaseRequest.getPurchaseDate())
                .customerBalance(purchaseRequest.getCustomerBalance())
                .build();

       return purchaseRepository.save(purchase);

    }

       public Iterable<Purchase> getAllPurchase(){
            return purchaseRepository.findAll();
        }
}
