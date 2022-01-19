package com.cjss.InventoryService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {
    private Integer skuCode;
    private Integer quantityAvailable;
}
