package com.ivoyant.internship_project_1.controllers;

import com.ivoyant.internship_project_1.service_Impl.VendorServiceImpl;
import com.ivoyant.internship_project_1.dto_classes.VendorDTO;
import com.ivoyant.internship_project_1.models.Vendor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Vendor insertedRecord = vendorService.createVendor(vendor);
        return new ResponseEntity<>(insertedRecord,HttpStatus.CREATED);
    }

    @GetMapping("/ok")
    public ResponseEntity<?> endPointCheck(){
        return new ResponseEntity<>("Working 200 OK",HttpStatus.OK);
    }

}


