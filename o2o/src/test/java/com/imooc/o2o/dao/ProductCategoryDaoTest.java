package com.imooc.o2o.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ProductCategory;

public class ProductCategoryDaoTest extends BaseTest{
@Autowired
private ProductCategoryDao productCategoryDao;

@Test
public void testQueryByshopId() throws Exception{
long shopId=1;
List<ProductCategory>productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
System.out.println("该店铺自定义类别数为："+productCategoryList.size());
}}
