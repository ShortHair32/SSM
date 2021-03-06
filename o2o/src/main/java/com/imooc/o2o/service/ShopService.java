package com.imooc.o2o.service;

import java.io.File;
import java.io.InputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;
public interface ShopService {
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
     ShopExecution addShop(Shop shop,InputStream shopImgInputStream,String fileName)throws ShopOperationException;
     Shop getByShopId(long shopId);
     ShopExecution modifyShop(Shop shop,InputStream shopImgInputStream,String fileName)throws ShopOperationException;
}
