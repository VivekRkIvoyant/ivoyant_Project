package com.ivoyant.internship_project_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferStats {

    private int x_transfer_id;

    private int x_product_id;

    private int x_seller_id;

    private int quantity_moved;

}
