package com.ivoyant.internship_project_1.service_Impl;

import com.ivoyant.internship_project_1.dto.ProductDTO;
import com.ivoyant.internship_project_1.model.Product;
import com.ivoyant.internship_project_1.services_interface.ProductServiceInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;

@Component
public class ProductServiceImpl implements ProductServiceInterface {

    private final JdbcTemplate jdbcTemplate;

    public ProductServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
        String query = "INSERT INTO product (product_name,product_description,product_price,product_status,seller_id) VALUES (?,?,?,?,?)";
//        return jdbcTemplate.queryForObject()
        return null;
    }

    @Override
    public ProductDTO getProductById(int x_product_Id) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(int x_product_Id, ProductDTO product) {
        return null;
    }

    @Override
    public void deleteProduct(int x_product_Id) {

    }

    @Override
    public List<ProductDTO> listProductsBySellerId(int x_seller_Id) {
        return List.of();
    }

    @Override
    public List<ProductDTO> getProductsByStatus(String status) {
        return List.of();
    }

    @Override
    public boolean existsById(int productId) {
        return false;
    }

    @Override
    public ProductDTO convertToDTO(Product product) {
        return null;
    }

    @Override
    public Product convertToEntity(ProductDTO productDTO) {
        return null;
    }
}
