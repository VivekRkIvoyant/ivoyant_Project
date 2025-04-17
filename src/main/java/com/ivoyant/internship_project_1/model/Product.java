package com.ivoyant.internship_project_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int x_product_id;

    private String product_name;

    private String product_description;

    private int product_price;

    private String product_status;

    private LocalDateTime created_at = LocalDateTime.now();

    private LocalDateTime updated_at;

}
