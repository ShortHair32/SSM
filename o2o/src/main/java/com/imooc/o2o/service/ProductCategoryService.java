package com.imooc.o2o.service;

import java.util.List;

import com.imooc.o2o.entity.ProductCategory;

public interface ProductCategoryService {
	//查询指定某个店铺下的商品类别信息
List<ProductCategory>getProductCategoryList(long shopId);
}
