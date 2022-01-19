package com.cjss.InventoryService;

import com.cjss.InventoryService.repo.InventoryRepository;
import com.cjss.InventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}

}
