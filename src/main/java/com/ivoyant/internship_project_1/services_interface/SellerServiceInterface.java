package com.ivoyant.internship_project_1.services_interface;

import com.ivoyant.internship_project_1.dto.SellerDTO;
import com.ivoyant.internship_project_1.model.Seller;

import java.util.List;

public interface SellerServiceInterface {

    List<SellerDTO> getAllSellers();

    SellerDTO getSellerById(int x_seller_Id);

    Seller createSeller(SellerDTO sellerDTO);

    SellerDTO updateSeller(int x_seller_Id, SellerDTO sellerDTO);

    void deleteSeller(int x_seller_Id);

    SellerDTO findSellerByName(String seller_name);

    boolean existsById(int x_seller_Id);

    SellerDTO convertToDTO(Seller seller);

}


