package com.cjss.InventoryService.service;

import com.cjss.InventoryService.entity.InventoryEntity;
import com.cjss.InventoryService.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;


    public Optional<Integer> get(){
        return repository.findSkuCode(1);
    }
    public Integer addQuantity(Integer skucode, Integer qty){
        if (repository.getBySkuCode(skucode)==null) {
            return   repository.save(new InventoryEntity(skucode,qty)).getQuantityAvailable();
        }
        Integer qtyA = getQuantity(skucode);
        qtyA=qtyA+qty;
        return   repository.upadateInventory(skucode,qtyA);

    }
    public Integer quantityAfterOrder(Integer skucode, Integer qty){
        if (repository.getBySkuCode(skucode).getQuantityAvailable()<qty) {
            return   0;
        }
        Integer qtyA = getQuantity(skucode);
        qtyA=qtyA-qty;
        return   repository.upadateInventory(skucode,qtyA);

    }

    private Integer getQuantity(Integer skucode){
        return repository.getBySkuCode(skucode).getQuantityAvailable();

    }
}
