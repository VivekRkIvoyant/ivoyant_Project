package com.ivoyant.internship_project_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private int x_product_id;

    private String product_name;

    private String product_description;

    private int product_price;

    private String product_status;

    private int seller_id;

}
