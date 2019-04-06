package com.imooc.o2o.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopOperationException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImageUtil;
import com.imooc.o2o.util.PathUtil;
@Service
public class ShopServiceImpl implements ShopService{
    @Autowired
	private ShopDao shopDao;
    @Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {
		if(shop==null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			shop.setEnableStatus(0);
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			//添加店铺信息
			int effectedNum=shopDao.insertShop(shop);
			if(effectedNum<=0) {
				throw new ShopOperationException("店铺创建失败");
			}else {
				if(shopImgInputStream!=null) {
					//存储图片
					try{
						addShopImg(shop, shopImgInputStream,fileName);
						}
				catch(Exception e) {
					throw new RuntimeException("addShopImg error"+e.getMessage());
				}
					//更新点剖图片地址
					effectedNum=shopDao.updateShop(shop);
					if(effectedNum<=0) {
						throw new ShopOperationException("更新图片地址失败");
					}
			}
			}
		}catch(Exception e) {
			throw new ShopOperationException("addShop error:"+e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	} 
	private void addShopImg(Shop shop,InputStream shopImgInputStream,String fileName) {
		String dest=PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr=ImageUtil.generateThumbnail(shopImgInputStream,fileName,dest);
		shop.setShopImg(shopImgAddr);
	}
	public Shop getByShopId(long shopId) {
		return shopDao.queryByShopId(shopId);
	}
	public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName)
			throws ShopOperationException {
		if(shop==null||shop.getShopId()==null) {
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}else {
			
			try{//1判断是否需要处理图片
			if(shopImgInputStream!=null&&fileName!=null&&!"".equals(fileName)) {
				Shop tempShop=shopDao.queryByShopId(shop.getShopId());
				if(tempShop.getShopImg()!=null) {
					ImageUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addShopImg(shop, shopImgInputStream, fileName);
			}
			//2更新店铺信息
			shop.setLastEditTime(new Date());
			int effectedNum=shopDao.updateShop(shop);
			if(effectedNum<=0) {
				return new ShopExecution(ShopStateEnum.INNER_ERROR);
			}else {
				shop=shopDao.queryByShopId(shop.getShopId());
				return new ShopExecution(ShopStateEnum.SUCCESS,shop);
			}}catch(Exception e) {
				throw new ShopOperationException("modifyShop error:"+e.getMessage());
			}
		}
        

	}
}