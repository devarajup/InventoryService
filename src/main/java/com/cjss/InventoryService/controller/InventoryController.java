package com.cjss.InventoryService.controller;

import com.cjss.InventoryService.entity.InventoryEntity;
import com.cjss.InventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService service;
    @GetMapping("/get")
    public Optional<Integer> get(){
        System.out.println(service.get());
        return  service.get();
    }

    @PostMapping("/add/{skucode}/{qty}")
    public Integer addQuantity(
            @PathVariable  Integer skucode,
            @PathVariable Integer qty){

return service.addQuantity(skucode,qty);
    }
    @GetMapping("/order/{skucode}/{quantity}")
    public Integer addPlaceOrder(@PathVariable Integer skucode,
                                 @PathVariable Integer quantity){
      return  service. quantityAfterOrder(skucode,quantity);
    }
}

