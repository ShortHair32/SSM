package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.dao.ShopCategoryDao;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.service.ShopCategoryService;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
@Autowired
private ShopCategoryDao shopCategoryDao;
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// TODO Auto-generated method stub
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}
