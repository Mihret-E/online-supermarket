package com.act.onlinesupermarket;

import com.act.onlinesupermarket.domains.Account;
import com.act.onlinesupermarket.domains.Purchase;
import com.act.onlinesupermarket.dto.PurchaseRequest;
import com.act.onlinesupermarket.services.PurchaseService;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class PurchaseServiceTest {
   @Autowired
   private PurchaseService purchaseService;


    @Test
    public void shouldCreateSucessfulPurchase() throws Exception {
//given
        PurchaseRequest purchaseRequest = PurchaseRequest.builder()
                .itemsId(1L)
                .custId(1L)
                .itemName("Ketchup")
                .itemPrice(20.0)
                .quantity(5)
                .totalPrice(100.0)
                .purchaseDate(LocalDate.now())
                .customerBalance(2000.0)
                .build();


        //@NotNull
        Purchase  purchase = purchaseService.purchaseItem(purchaseRequest);

      //  Account account = new Account();
        assertNotNull(purchase.getPurchaseId());
        assertEquals(1900.0,purchase.getCustomer().getBalance());


    }



}
