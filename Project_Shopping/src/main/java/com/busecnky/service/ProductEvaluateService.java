package com.busecnky.service;

import java.util.List;

import com.busecnky.entity.ProductEvaluate;
import com.busecnky.repository.ProductEvaluateDao;

public class ProductEvaluateService implements IService<ProductEvaluate> {

private ProductEvaluateDao productEvaluateDao;
	
	public ProductEvaluateService() {
		this.productEvaluateDao = new ProductEvaluateDao();
	}
	
	@Override
	public void create(ProductEvaluate entity) {
		productEvaluateDao.create(entity);
	}

	@Override
	public void delete(long id) {
		productEvaluateDao.delete(id);
	}

	@Override
	public void update(long id, ProductEvaluate entity) {
		productEvaluateDao.update(id, entity);
	}

	@Override
	public List<ProductEvaluate> listAll() {
		return productEvaluateDao.listAll();
	}

	@Override
	public ProductEvaluate find(long id) {
		ProductEvaluate productEvaluate = productEvaluateDao.find(id);
		return productEvaluate;
	}


	
}
