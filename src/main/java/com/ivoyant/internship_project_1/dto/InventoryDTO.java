package com.ivoyant.internship_project_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {

    private int x_inventory_id;

    private int x_product_id;

    private int x_seller_id;

    private int quantity;

}
