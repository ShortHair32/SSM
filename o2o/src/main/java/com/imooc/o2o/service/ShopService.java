package com.imooc.o2o.service;

import java.io.File;
import java.io.InputStream;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopOperationException;
public interface ShopService {
     ShopExecution addShop(Shop shop,InputStream shopImgInputStream,String fileName)throws ShopOperationException;
}
