package com.dxc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer Id;
   private String  Name;
   private Double Price;
	
}
