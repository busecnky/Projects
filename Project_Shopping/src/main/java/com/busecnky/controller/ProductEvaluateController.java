package com.busecnky.controller;

import java.util.List;
import java.util.Optional;

import com.busecnky.entity.Customer;
import com.busecnky.entity.Product;
import com.busecnky.entity.ProductEvaluate;
import com.busecnky.service.ProductEvaluateService;
import com.busecnky.service.ProductService;
import com.busecnky.utils.BAUtils;

public class ProductEvaluateController {
	
	ProductEvaluateService productEvaluateService;
	ProductService productService;
	
	public ProductEvaluateController() {
		productEvaluateService = new ProductEvaluateService();
		productService = new ProductService();

	}
	

	public void comment(Customer customer) {
		
		List<Product> listProduct = customer.getProducts();
		listProduct.forEach(System.out::println);
		
		if(!(listProduct.isEmpty())) {
			long id = BAUtils.readLong("Please enter product id that you want to comment: ");
			int point = BAUtils.readInt("Please enter the point ");
			String comment = BAUtils.readString("Please enter comment for this product: ");
			
			long customerId = customer.getId();
			
			ProductEvaluate productEvaluate = productEvaluateService.listAll().stream()
					.filter((p) -> p.getProduct().getId() == id && p.getCustomer().getId() == customerId).findAny()
					.orElse(null);
			if(productEvaluate != null) {
				ProductEvaluate productEvaluate2 = new ProductEvaluate(comment, point, productService.find(id), customer);
				productEvaluateService.create(productEvaluate2);
			}else {
				System.out.println("You must have purchased the product before you can comment ");
			}
			
		}else {
			System.out.println("You must have purchased the product before you can comment ");
		}
		
		
	
		
	}


	public void commentListByProducts(Customer customer) {
		long id = BAUtils.readLong("Please enter product id that you want to see all comments: ");
		
		List<ProductEvaluate> commentList = productEvaluateService.listAll().stream().filter((a) -> a.getProduct().getId() == id).toList();
		if(!(commentList.isEmpty())) {
			System.out.println(commentList);
		}else {
			System.out.println("\nThere is no comment for this product.\n");
		}
		
	}

}
