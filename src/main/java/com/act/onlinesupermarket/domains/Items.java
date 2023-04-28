package com.act.onlinesupermarket.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=15 , min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Item Name cannot be empty!")
    private String itemName;

    @Column(nullable = false)
    @NotNull(message = "Quantity cannot be empty!")
    private Integer quantity;

    @Column(nullable = false)
    private Double itemPrice = 0.0;
}
