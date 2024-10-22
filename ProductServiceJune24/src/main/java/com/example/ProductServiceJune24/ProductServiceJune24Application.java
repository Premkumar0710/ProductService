package com.example.ProductServiceJune24;

import com.example.ProductServiceJune24.Models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceJune24Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceJune24Application.class, args);
		Product product = new Product();
		product.setTitle("Iphone 15");
	}
}
