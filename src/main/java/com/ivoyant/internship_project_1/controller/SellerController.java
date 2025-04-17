package com.ivoyant.internship_project_1.controller;

import com.ivoyant.internship_project_1.dto.SellerDTO;
import com.ivoyant.internship_project_1.service_Impl.SellerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    private final SellerServiceImpl sellerService;

    public SellerController(SellerServiceImpl sellerService){
        this.sellerService =sellerService;
    }

    @PostMapping
    public ResponseEntity<Object> createSeller(@RequestBody SellerDTO seller){
        if(seller!=null){
            return new ResponseEntity<>(sellerService.createSeller(seller), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{x_seller_Id}")
    public ResponseEntity<Object> getSellerById(@PathVariable int x_seller_Id){
        Optional<SellerDTO> seller = Optional.ofNullable(sellerService.getSellerById(x_seller_Id));
        if(seller.isPresent()){
            return new ResponseEntity<>(seller,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{x_seller_Id}")
    public ResponseEntity<Object> deleteSeller(@PathVariable int x_seller_Id){
        Optional<SellerDTO> seller = Optional.ofNullable(sellerService.getSellerById(x_seller_Id));
        if(seller.isPresent()){
            sellerService.deleteSeller(x_seller_Id);
            return new ResponseEntity<>(HttpStatus.GONE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

