package com.ivoyant.internship_project_1.controller;

import com.ivoyant.internship_project_1.dto.SellerDTO;
import com.ivoyant.internship_project_1.service_Impl.SellerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            return new ResponseEntity<>("Seller Deleted!",HttpStatus.GONE);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{x_seller_Id}")
    public ResponseEntity<Object> updateSeller(@PathVariable int x_seller_Id , @RequestBody SellerDTO seller){
        if(seller==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Optional<SellerDTO> optionalSeller = Optional.ofNullable(sellerService.getSellerById(x_seller_Id));
        if(optionalSeller.isPresent()){
            sellerService.updateSeller(x_seller_Id, seller);
            SellerDTO sellerDTO = sellerService.getSellerById(x_seller_Id);
            return new ResponseEntity<>(sellerDTO,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get-All-Sellers")
    public ResponseEntity<Optional<List<SellerDTO>>> getAllSellers(){
        Optional<List<SellerDTO>> sellerList = Optional.ofNullable(sellerService.getAllSellers());
        if(sellerList.isPresent()){
            return new ResponseEntity<>(sellerList,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getSellerPresence/{x_seller_Id}")
    public ResponseEntity<Boolean> checkSellerPresence(@PathVariable int x_seller_Id){
        boolean result = sellerService.existsById(x_seller_Id);
        if(result!=true){
            return new ResponseEntity<>(Boolean.FALSE,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Boolean.TRUE,HttpStatus.FOUND);
    }

    @GetMapping("/name/{seller_name}")
    public ResponseEntity<Object> findSellerByName(@PathVariable String seller_name){
        Optional<SellerDTO> sellerDTOOptional = Optional.ofNullable(sellerService.findSellerByName(seller_name));
        if(sellerDTOOptional.isPresent()){
            return new ResponseEntity<>(sellerDTOOptional,HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}


