package com.cjss.InventoryService.service;

import com.cjss.InventoryService.entity.InventoryEntity;
import com.cjss.InventoryService.model.InventoryModel;
import com.cjss.InventoryService.repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository repository;
    private RestTemplate rt = new RestTemplate();

    public String addInventory(InventoryModel model) {
        String uri = "http://localhost:8082/get-sku/" + model.getSkuCode();

        ResponseEntity<Boolean> res = rt.getForEntity(uri, Boolean.class);
        if (res.getBody() != true)
            return "sku code not exist";

        if (repository.getBySkuCode(model.getSkuCode()) == null) {
            return repository.save(new InventoryEntity(model.getSkuCode(), model.getQuantityAvailable())).getQuantityAvailable() + "quantity added to " + model.getSkuCode();
        }
        Integer qtyA = getQuantity(model.getSkuCode());
        qtyA = qtyA + model.getQuantityAvailable();
        repository.upadateInventory(model.getSkuCode(), qtyA);
        return " Total quantity available " + qtyA;

    }

    public InventoryModel placeOrder(InventoryModel model) {
        if (repository.existsBySkuCode(model.getSkuCode())!=true)
            return new InventoryModel();

        if (repository.getBySkuCode(model.getSkuCode()).getQuantityAvailable() < model.getQuantityAvailable()) {
            return new InventoryModel();
        }
        Integer qtyA = getQuantity(model.getSkuCode());
        qtyA = qtyA - model.getQuantityAvailable();
        repository.upadateInventory(model.getSkuCode(), qtyA);
        InventoryEntity entity=repository.getBySkuCode(model.getSkuCode());
        System.out.println(entity.getSkuCode());
        return new InventoryModel(entity.getSkuCode(),entity.getQuantityAvailable());

    }

    public Integer getQuantity(Integer skucode) {
        return repository.getBySkuCode(skucode).getQuantityAvailable();

    }
}
