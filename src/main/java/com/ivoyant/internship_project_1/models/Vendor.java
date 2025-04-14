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
public class Vendor {

    private int x_vendor_id;

    private String vendor_name;

    private LocalDateTime created_at = LocalDateTime.now();

}
