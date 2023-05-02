package com.act.onlinesupermarket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import static java.time.LocalDate.now;

@Builder
@Data
public class PurchaseRequest {

    private Long itemsId;
    private Long custId;
    private String itemName;
    private Double itemPrice;
    private Integer quantity;
    private Double totalPrice;
    private LocalDate purchaseDate = now();
    private Double customerBalance;

}
