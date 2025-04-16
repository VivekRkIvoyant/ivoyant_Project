package com.ivoyant.internship_project_1.services_interfaces;

import com.ivoyant.internship_project_1.dto_classes.ProductDTO;
import com.ivoyant.internship_project_1.models.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    ProductDTO createProduct(ProductDTO product);

    ProductDTO getProductById(int x_product_Id);

    ProductDTO updateProduct(int x_product_Id,ProductDTO product);

    void deleteProduct(int x_product_Id);

    List<ProductDTO> listProductsBySellerId(int x_seller_Id);

    List<ProductDTO> getProductsByStatus(String status);

    boolean existsById(int productId);

    ProductDTO convertToDTO(Product product);

    Product convertToEntity(ProductDTO productDTO);

}
