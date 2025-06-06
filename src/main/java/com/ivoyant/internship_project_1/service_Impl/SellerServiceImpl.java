package com.ivoyant.internship_project_1.service_Impl;

import com.ivoyant.internship_project_1.dto.SellerDTO;
import com.ivoyant.internship_project_1.model.Seller;
import com.ivoyant.internship_project_1.services_interface.SellerServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@Component
public class SellerServiceImpl implements SellerServiceInterface {

    private final JdbcTemplate jdbcTemplate;

    public SellerServiceImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<SellerDTO> getAllSellers() {
        String query = "SELECT seller_id , seller_name , seller_address , seller_phone FROM seller";
        return jdbcTemplate.query(query,(rs,rowNum)->{
            SellerDTO sellerDTO = new SellerDTO();
            sellerDTO.setX_seller_id(rs.getInt("seller_id"));
            sellerDTO.setSeller_name(rs.getString("seller_name"));
            sellerDTO.setSeller_address(rs.getString("seller_address"));
            sellerDTO.setSeller_phone(rs.getString("seller_phone"));
            return sellerDTO;
        });
    }

    @Override
    public SellerDTO getSellerById(int x_seller_Id) {
        try {
            String query = "SELECT seller_id , seller_name , seller_address , seller_phone from seller WHERE seller_id = ?";
            return jdbcTemplate.queryForObject(query,new Object[]{x_seller_Id},
                    (rs, rowNum) -> new SellerDTO(
                            rs.getInt("seller_id"),
                            rs.getString("seller_name"),
                            rs.getString("seller_address"),
                            rs.getString("seller_phone")
                    ));
        }catch (Exception e){
            log.error("Seller Not Found");
//            throw new RuntimeException("Seller Not Found: "+e.getMessage());
            return null;
        }
    }

    @Transactional
    @Override
    public Seller createSeller(SellerDTO sellerDTO) {
        try {
            String query = "INSERT INTO seller (seller_name, seller_address, seller_phone) " +
                    "VALUES (?,?,?) RETURNING seller_id, seller_name, seller_address, seller_phone, created_at";

            return jdbcTemplate.queryForObject(query,
                    new Object[]{
                            sellerDTO.getSeller_name(),
                            sellerDTO.getSeller_address(),
                            sellerDTO.getSeller_phone()
                    },
                    (res, rowNum) -> {
                        Seller seller = new Seller();
                        seller.setX_seller_id(res.getInt("seller_id"));
                        seller.setSeller_name(res.getString("seller_name"));
                        seller.setSeller_address(res.getString("seller_address"));
                        seller.setSeller_phone(res.getString("seller_phone"));
                        seller.setCreated_at(res.getTimestamp("created_at").toLocalDateTime());
                        return seller;
                    });

        } catch (Exception e) {
            log.error("Error Creating Seller: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public SellerDTO updateSeller(int x_seller_Id, SellerDTO sellerDTO) {
        SellerDTO existingSeller = getSellerById(x_seller_Id);
        if(existingSeller==null){
            throw new RuntimeException("Seller Not Found With Id: "+x_seller_Id);
        }
        String query = "UPDATE seller SET seller_name = ?,seller_address = ?, seller_phone = ? WHERE seller_id = ?";
        int rowsAffected = jdbcTemplate.update(query,
                sellerDTO.getSeller_name(),
                sellerDTO.getSeller_address(),
                sellerDTO.getSeller_phone(),
                x_seller_Id);
        if(rowsAffected==0){
            log.error("Update failed for Seller ID: " + x_seller_Id);
            throw new RuntimeException("Seller Not Found: "+x_seller_Id);
        }
        SellerDTO updatedSeller = new SellerDTO();
        updatedSeller.setX_seller_id(x_seller_Id);
        updatedSeller.setSeller_name(sellerDTO.getSeller_name());
        updatedSeller.setSeller_address(sellerDTO.getSeller_address());
        updatedSeller.setSeller_phone(sellerDTO.getSeller_phone());
        return updatedSeller;
    }

    @Transactional
    @Override
    public void deleteSeller(int x_seller_Id) {
        try {
            String query = "DELETE FROM seller WHERE seller_id=?";
            jdbcTemplate.update(query,x_seller_Id);
        }catch (Exception e){
            log.error(e.getMessage()+"Unable to delete User");
            throw new RuntimeException("Error Deleting User");
        }
    }

    @Override
    public SellerDTO findSellerByName(String seller_name) {
        String query = "SELECT seller_name, seller_address, seller_phone FROM seller WHERE seller_name = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{seller_name},
                (rs, rowNum) -> {
                    SellerDTO sellerDTO = new SellerDTO();
                    sellerDTO.setSeller_name(rs.getString("seller_name"));
                    sellerDTO.setSeller_address(rs.getString("seller_address"));
                    sellerDTO.setSeller_phone(rs.getString("seller_phone"));
                    return sellerDTO;
                }
        );
    }

    @Override
    public boolean existsById(int x_seller_Id) {
        SellerDTO result = getSellerById(x_seller_Id);
        if(result!=null){
            return true;
        }
        return false;
    }

    @Override
    public SellerDTO convertToDTO(Seller seller) {
        SellerDTO sellerDTO = new SellerDTO();
        sellerDTO.setX_seller_id(seller.getX_seller_id());
        sellerDTO.setSeller_name(seller.getSeller_name());
        sellerDTO.setSeller_address(seller.getSeller_address());
        sellerDTO.setSeller_phone(seller.getSeller_phone());
        return sellerDTO;
    }
}
