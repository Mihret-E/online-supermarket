package com.act.onlinesupermarket.domains;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String purchaseId;

    //@Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "itemId cannot be empty!")
    private Items items;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "Customer Id cannot be empty!")
    private Account customer;

    @NotNull(message = "Balance cannot be empty!")
    private Double customerBalance;

    @Size(max=15 , min = 3)
    @Column(nullable = false)
    @NotBlank(message = "Item Name cannot be empty!")
    private String itemName;

    @Column(nullable = false)
    @NotNull(message = "Quantity cannot be empty!")
    private Integer quantity;

    @Column(nullable = false)
    private Double itemPrice = 0.0;

    @Column(nullable = false)
    private Double totalPrice = 0.0;

    @Column(nullable = false)
    private LocalDate purchaseDate = LocalDate.now();


}
