package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.entity.Product;
import com.dxc.repository.ProductRepository;
import com.dxc.service.ProductService;
import jakarta.validation.constraints.NotNull;


@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ProductService service;

	
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product",new Product());
		return "index";
	}
	
	@PostMapping("/product")    //@Validated it will check binding result is satisfying the rules or not 
	public String saveProduct(@Validated @ModelAttribute ("product")  Product product,BindingResult result,Model model) { 
		if(result.hasErrors()) {                                                     //BindingResult obj it tell validation fail or not
			return "index";
		}
		System.out.println(product);
		product = service.saveProduct(product);
	    if(product.getPid() != null) {
	    	model.addAttribute("msg","Product Saved Successfully...!");
	    }
		return "index";
	}
	
	@GetMapping("/products")
	public String loadProducts(Model model) {
	    List<Product> list = service.getAllProducts();
		model.addAttribute("products",list);
		return "data";
	}
	@GetMapping("/edit")
    public String editProduct(@RequestParam ("pid") Integer pid ,Product product,Model model) {
		Optional<Product> p = service.getProduct(pid);
		model.addAttribute("product",p);
    	return"index";
    }
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam ("pid")Integer pid,Model model) {
		boolean deleteObj = service.deleteProduct(pid);
		if(deleteObj) {
		  //  repo.deleteById(pid);
			model.addAttribute("msg","Product Deleted Successfully...!");
			model.addAttribute("products",service.getAllProducts());

		}else {
			model.addAttribute("msg","Product Not Available with this ID!");
		}
		return "data";
	}
}
