package com.dxc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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

	public Optional<Product> getProduct(Integer pid) {
		 Optional<Product> p = repo.findById(pid);
	    	return p;
	    }
	
	public boolean deleteProduct(Integer pid) {
		Optional<Product> pro = repo.findById(pid);
	    if(pro.isPresent()){
		repo.deleteById(pid);
		return true;
	    }
		return false ;
	}
	
}
