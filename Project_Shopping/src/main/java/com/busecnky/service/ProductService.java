package com.busecnky.service;

import java.util.List;

import com.busecnky.entity.Product;
import com.busecnky.repository.ProductDao;

public class ProductService implements IService<Product> {

private ProductDao productDao;
	
	public ProductService() {
		this.productDao = new ProductDao();
	}
	
	@Override
	public void create(Product entity) {
		productDao.create(entity);
	}

	@Override
	public void delete(long id) {
		productDao.delete(id);
	}

	@Override
	public void update(long id, Product entity) {
		productDao.update(id, entity);
	}

	@Override
	public List<Product> listAll() {
		return productDao.listAll();
	}

	@Override
	public Product find(long id) {
		Product product = productDao.find(id);
		return product;
	}

	public List<Product> listAll2() {
		return productDao.listAll2();
	}
	
}
