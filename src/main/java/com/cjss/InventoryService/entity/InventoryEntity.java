package com.cjss.InventoryService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory_table")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer skuCode;
    private Integer quantityAvailable;



    public InventoryEntity(Integer skuCode, Integer quantityAvailable) {
        this.skuCode = skuCode;
        this.quantityAvailable = quantityAvailable;
    }
}
