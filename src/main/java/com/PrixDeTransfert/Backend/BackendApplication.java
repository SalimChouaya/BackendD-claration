package com.PrixDeTransfert.Backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.PrixDeTransfert.Backend.services", 
        "com.PrixDeTransfert.Backend.models", 
        "com.PrixDeTransfert.Backend.repositories", 
        "com.PrixDeTransfert.Backend.controllers",
        "com.PrixDeTransfert.Backend.config",
        "com.PrixDeTransfert.Backend.mappers",
        "com.PrixDeTransfert.Backend.exceptions"
})
public class BackendApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
