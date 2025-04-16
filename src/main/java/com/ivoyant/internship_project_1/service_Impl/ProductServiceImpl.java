package com.ivoyant.internship_project_1.service_Impl;

import com.ivoyant.internship_project_1.dto_classes.ProductDTO;
import com.ivoyant.internship_project_1.models.Product;
import com.ivoyant.internship_project_1.services_interfaces.ProductServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServiceInterface {

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) {
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
