package com.cjss.InventoryService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryModel {
    @NotNull(message = "SKU Code required")
    private Integer skuCode;
    @NotNull(message = "Quantity  required")
    private Integer quantityAvailable;
}
