package com.cjss.InventoryService.entity;

import com.cjss.InventoryService.util.CustomIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventory_table")
public class InventoryEntity {
    @Id
    @GenericGenerator(name = "inventory_id_gen",
            strategy = "com.cjss.InventoryService.util.CustomIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "INV"),
                    @org.hibernate.annotations.Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") }
    )
    @GeneratedValue(generator = "inventory_id_gen",strategy = GenerationType.IDENTITY)
    @Column(name = "InventoryId", nullable = false)
    private String InventoryId;
    @Column(unique = true)
    private Integer skuCode;
    private Integer quantityAvailable;



    public InventoryEntity(Integer skuCode, Integer quantityAvailable) {
        this.skuCode = skuCode;
        this.quantityAvailable = quantityAvailable;
    }
}
