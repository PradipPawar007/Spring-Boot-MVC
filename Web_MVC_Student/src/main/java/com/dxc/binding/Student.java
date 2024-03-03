package com.dxc.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private String name ;
	private String email;
	private String gender;
	private String course;
	private String[] timings;
	
}
