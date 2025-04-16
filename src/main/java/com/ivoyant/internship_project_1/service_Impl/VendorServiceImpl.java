package com.ivoyant.internship_project_1.service_Impl;


import com.ivoyant.internship_project_1.dto_classes.VendorDTO;
import com.ivoyant.internship_project_1.models.Vendor;
import com.ivoyant.internship_project_1.services_interfaces.VendorServiceInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorServiceInterface {

    private final JdbcTemplate jdbcTemplate;

    public VendorServiceImpl(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return List.of();
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
            e.printStackTrace();
            throw new RuntimeException("Vendor Not Found: " + x_vendor_Id +e.getMessage());
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
           throw new RuntimeException(e);
       }
    }

    @Override
    public VendorDTO updateVendor(int x_vendor_Id, VendorDTO vendor) {
        Vendor getVendor = getVendorById(x_vendor_Id);
        getVendor.setX_vendor_id(x_vendor_Id);
        getVendor.setVendor_name(vendor.getVendor_name());
        return createVendor(vendor);
    }

    @Transactional
    @Override
    public void deleteVendor(int x_vendor_Id) {
        String query = "DELETE FROM vendor WHERE vendor_id = ?";
        jdbcTemplate.update(query, x_vendor_Id);
    }

    @Override
    public VendorDTO convertToDTO(Vendor vendor) {
        return null;
    }

    @Override
    public Vendor convertToEntity(VendorDTO vendorDTO) {
        return null;
    }
}

