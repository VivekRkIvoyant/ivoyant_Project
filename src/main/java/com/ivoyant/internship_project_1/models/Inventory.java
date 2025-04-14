package com.ivoyant.internship_project_1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    private int x_inventory_id;

    private int x_product_id;

    private int x_seller_id;

    private int quantity;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime updated_at;

}
