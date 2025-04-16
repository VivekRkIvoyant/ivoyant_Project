package com.ivoyant.internship_project_1.services_interfaces;


import com.ivoyant.internship_project_1.dto_classes.SellerDTO;
import com.ivoyant.internship_project_1.dto_classes.VendorDTO;
import com.ivoyant.internship_project_1.models.Seller;
import com.ivoyant.internship_project_1.models.Vendor;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(int x_vendor_Id);

    Vendor createVendor(VendorDTO vendor);

    VendorDTO updateVendor(int x_vendor_Id,VendorDTO vendor);

    void deleteVendor(int x_vendor_Id);

    VendorDTO convertToDTO(Vendor vendor);

    Vendor convertToEntity(VendorDTO vendorDTO);

}
