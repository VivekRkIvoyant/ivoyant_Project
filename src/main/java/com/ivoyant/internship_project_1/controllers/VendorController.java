package com.ivoyant.internship_project_1.controllers;

import com.ivoyant.internship_project_1.service_Impl.VendorServiceImpl;
import com.ivoyant.internship_project_1.dto_classes.VendorDTO;
import com.ivoyant.internship_project_1.models.Vendor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {
    
    private final VendorServiceImpl vendorService;
    
    public VendorController(VendorServiceImpl vendorService){
        this.vendorService = vendorService;
    }
    
    @PostMapping
    public ResponseEntity<Object> createVendor(@RequestBody VendorDTO vendor){
        if (vendor==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        VendorDTO insertedRecord = vendorService.createVendor(vendor);
        return new ResponseEntity<>(insertedRecord,HttpStatus.CREATED);
    }

    @GetMapping("/{x_vendor_Id}")
    public ResponseEntity<Object> getVendorById(@PathVariable int x_vendor_Id){
        Optional<Vendor> vendor = Optional.ofNullable(vendorService.getVendorById(x_vendor_Id));
        if(vendor.isPresent()){
            return new ResponseEntity<>(vendor,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{x_vendor_Id}")
    public ResponseEntity<Object> deleteVendor(@PathVariable int x_vendor_Id){
        Optional<Vendor> vendor = Optional.ofNullable(vendorService.getVendorById(x_vendor_Id));
        if(vendor.isPresent()){
            vendorService.deleteVendor(x_vendor_Id);
            return new ResponseEntity<>("Vendor Deleted!",HttpStatus.GONE);
        }
        return new ResponseEntity<>("Vendor Not Found",HttpStatus.NOT_FOUND);
    }

}


