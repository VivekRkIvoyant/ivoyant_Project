package com.ivoyant.internship_project_1.services_interface;


import com.ivoyant.internship_project_1.dto.VendorDTO;
import com.ivoyant.internship_project_1.model.Vendor;

import java.util.List;

public interface VendorServiceInterface {

    List<VendorDTO> getAllVendors();

    Vendor getVendorById(int x_vendor_Id);

    VendorDTO createVendor(VendorDTO vendor);

    VendorDTO updateVendor(int x_vendor_Id,VendorDTO vendor);

    void deleteVendor(int x_vendor_Id);

    VendorDTO convertToDTO(Vendor vendor);

}
