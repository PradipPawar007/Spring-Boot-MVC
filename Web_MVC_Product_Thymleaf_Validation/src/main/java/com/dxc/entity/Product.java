package com.dxc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name="product_entity")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NotBlank(message="Name is mandatory")
	@Size(min=3, max=15,message="Name should have 3 to 15 character" )
	private String name;
	
	@NotNull(message="Price is mandatory")
	@Positive(message="Price should be positive or greater than 1")
	private Double price;
	
	@NotNull(message="Quantity is mandatory")
	@Positive(message="Quantity should be positive or greater than 1")
	private Integer qty;
}
