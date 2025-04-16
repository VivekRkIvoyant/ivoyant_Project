package com.ivoyant.internship_project_1.service_Impl;


import com.ivoyant.internship_project_1.dto_classes.VendorDTO;
import com.ivoyant.internship_project_1.models.Vendor;
import com.ivoyant.internship_project_1.services_interfaces.VendorService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final JdbcTemplate jdbcTemplate;

    public VendorServiceImpl(JdbcTemplate template){
        this.jdbcTemplate = template;
    }

    @Override
    public List<VendorDTO> getAllVendors() {
        return List.of();
    }

    @Override
    public VendorDTO getVendorById(int x_vendor_Id) {
//        try {
//            String query = "SELECT vendor_id, vendor_name FROM vendor WHERE vendor_id = ?";
//            return jdbcTemplate.queryForObject(query,new Object[]{x_vendor_Id},
//                    )
//        }
        return null;
    }

    @Override
    @Transactional
    public Vendor createVendor(VendorDTO vendorDTO) {
       try {
           String query = "INSERT INTO vendor (vendor_name) VALUES (?) RETURNING vendor_id, vendor_name, created_at";
           return jdbcTemplate.queryForObject(query, new Object[]{vendorDTO.getVendor_name()},
                   (rs, rowNum) -> {
                       Vendor vendor = new Vendor();
                       vendor.setX_vendor_id(rs.getInt("vendor_id"));
                       vendor.setVendor_name(rs.getString("vendor_name"));
                       vendor.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
                       return vendor;
                   });
       }catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public VendorDTO updateVendor(int x_vendor_Id, VendorDTO vendor) {
        return null;
    }

    @Override
    public void deleteVendor(int x_vendor_Id) {

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

