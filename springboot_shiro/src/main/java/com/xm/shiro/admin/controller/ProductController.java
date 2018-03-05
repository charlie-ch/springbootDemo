package com.xm.shiro.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

	
	@RequestMapping("getAll")
	public Object getAll(){
	
		return "adfdg";
	}
}
