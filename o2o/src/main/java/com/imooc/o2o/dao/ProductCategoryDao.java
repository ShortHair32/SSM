package com.imooc.o2o.dao;

import java.util.List;

import com.imooc.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
     List<ProductCategory>queryProductCategoryList(long shopId);
}
