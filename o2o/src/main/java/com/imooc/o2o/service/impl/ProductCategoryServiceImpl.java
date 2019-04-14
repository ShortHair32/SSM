package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.dao.ProductCategoryDao;
import com.imooc.o2o.entity.ProductCategory;
import com.imooc.o2o.service.ProductCategoryService;

public class ProductCategoryServiceImpl implements ProductCategoryService{
@Autowired
private ProductCategoryDao productCategoryDao;
	public List<ProductCategory> getProductCategoryList(long shopId) {
		
		return productCategoryDao.queryProductCategoryList(shopId);
	}

}
