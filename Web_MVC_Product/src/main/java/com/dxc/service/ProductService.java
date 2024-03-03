package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.entity.Product;
import com.dxc.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public Product saveProduct(Product p){
		return repo.save(p);
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
}
