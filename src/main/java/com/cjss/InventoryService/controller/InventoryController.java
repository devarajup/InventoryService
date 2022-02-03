package com.cjss.InventoryService.controller;

import com.cjss.InventoryService.model.InventoryModel;
import com.cjss.InventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/add-inventory")
    public String addInventory(@RequestBody InventoryModel model) {

        return service.addInventory(model);
    }

    @PostMapping("/reduce-quantity")
    public InventoryModel addPlaceOrder(@RequestBody InventoryModel model) {
        return service.placeOrder(model);
    }
    @PostMapping("/reduce-qty")
    public InventoryModel addPlaceOrder(@RequestParam("sku") String sku ,@RequestParam("qty") String qty) {

        return      service.placeOrder(new InventoryModel(Integer.valueOf(sku), Integer.valueOf(qty)));

    }

    @GetMapping("/quantity-available/{skucode}")
    public Integer getQuantity(@PathVariable Integer skucode) {
        return service.getQuantity(skucode);
    }
}

