package com.cjss.InventoryService.repo;

import com.cjss.InventoryService.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Integer> {
    @Query(value = "SELECT sku_code FROM ecommerce_project_db.product_sku_table where sku_code = :sku", nativeQuery = true)
    Optional<Integer> findSkuCode(Integer sku);

    InventoryEntity getBySkuCode(Integer skuCode);

    @Modifying
    @Transactional
    @Query("UPDATE InventoryEntity  SET quantityAvailable = :quantityAvailable WHERE skuCode=:skuCode")
    Integer upadateInventory(Integer skuCode,Integer quantityAvailable);
}
