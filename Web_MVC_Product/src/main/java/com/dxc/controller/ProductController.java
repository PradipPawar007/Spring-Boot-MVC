package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dxc.entity.Product;
import com.dxc.repository.ProductRepository;
import com.dxc.service.ProductService;


@Controller
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	@GetMapping("/products")
	public String loadProducts(Model model) {
		List<Product> prodList = service.getAllProducts();
		model.addAttribute("products",prodList);
		return "data";
	}
	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product",new Product());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute ("product")  Product product,Model model) { // @ModelAttribute whatvever data coming from view that data it will send back to view		
		
		product = service.saveProduct(product);
	    if(product.getPid() != null) {
	    	model.addAttribute("msg","Product Saved Successfully...!");
	    }
		return "index";
	}
	
}
