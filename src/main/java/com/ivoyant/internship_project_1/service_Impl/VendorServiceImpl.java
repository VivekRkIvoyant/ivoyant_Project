package com.ivoyant.internship_project_1.service_Impl;


import com.ivoyant.internship_project_1.dto.VendorDTO;
import com.ivoyant.internship_project_1.model.Vendor;
import com.ivoyant.internship_project_1.services_interface.VendorServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class VendorServiceImpl implements VendorServiceInterface {

    private final JdbcTemplate jdbcTemplate;

    public VendorServiceImpl(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        String query = "SELECT vendor_id, vendor_name FROM vendor";
        return jdbcTemplate.query(query, (rs, rowNum) -> {
            VendorDTO vendorDTO = new VendorDTO();
            vendorDTO.setX_vendor_id(rs.getInt("vendor_id"));
            vendorDTO.setVendor_name(rs.getString("vendor_name"));
            return vendorDTO;
        });
    }

    @Override
    public Vendor getVendorById(int x_vendor_Id) {
        try {
            String query = "SELECT vendor_id, vendor_name, created_at FROM vendor WHERE vendor_id = ?";
            return jdbcTemplate.queryForObject(query, new Object[]{x_vendor_Id},
                    (rs, rowNum) -> new Vendor(
                            rs.getInt("vendor_id"),
                            rs.getString("vendor_name"),
                            rs.getTimestamp("created_at").toLocalDateTime()
                    ));
        } catch (Exception e) {
            log.error("Vendor not found with ID {}.", x_vendor_Id, e);
            throw new RuntimeException("Vendor not found with ID {}."+x_vendor_Id+e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public VendorDTO createVendor(VendorDTO vendorDTO) {
       try {
           String query = "INSERT INTO vendor (vendor_name) VALUES (?) RETURNING vendor_id, vendor_name, created_at";
           return jdbcTemplate.queryForObject(query, new Object[]{vendorDTO.getVendor_name()},
                   (rs, rowNum) -> {
                       VendorDTO vendor = new VendorDTO();
                       vendor.setX_vendor_id(rs.getInt("vendor_id"));
                       vendor.setVendor_name(rs.getString("vendor_name"));
                       return vendor;
                   });
       }catch (Exception e) {
           log.error(e.getMessage());
           throw new RuntimeException(e.getMessage());
       }
    }

    @Transactional
    @Override
    public VendorDTO updateVendor(int x_vendor_Id, VendorDTO vendor) {
        Vendor existingVendor = getVendorById(x_vendor_Id);
        if (existingVendor == null) {
            throw new RuntimeException("Vendor with ID " + x_vendor_Id + " not found.");
        }
        String query = "UPDATE vendor SET vendor_name = ? WHERE vendor_id = ?";
        int rowsAffected = jdbcTemplate.update(query, vendor.getVendor_name(), x_vendor_Id);
        if (rowsAffected == 0) {
            log.error("Update failed for vendor ID: " + x_vendor_Id);
            throw new RuntimeException("Vendor Not Found: "+x_vendor_Id);
        }
        VendorDTO updatedDTO = new VendorDTO();
        updatedDTO.setX_vendor_id(x_vendor_Id);
        updatedDTO.setVendor_name(vendor.getVendor_name());
        return updatedDTO;
    }


    @Transactional
    @Override
    public void deleteVendor(int x_vendor_Id) {
        String query = "DELETE FROM vendor WHERE vendor_id = ?";
        jdbcTemplate.update(query, x_vendor_Id);
    }

    @Override
    public VendorDTO convertToDTO(Vendor vendor) {
        VendorDTO vendorDTO = new VendorDTO();
        vendorDTO.setX_vendor_id(vendor.getX_vendor_id());
        vendorDTO.setVendor_name(vendor.getVendor_name());
        return vendorDTO;
    }

}

