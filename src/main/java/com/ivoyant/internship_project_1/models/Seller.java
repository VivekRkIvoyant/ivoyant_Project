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
public class Seller {

    private int x_seller_id;

    private String seller_name;

    private String seller_address;

    private String seller_phone;

    private LocalDateTime created_at = LocalDateTime.now();

}
