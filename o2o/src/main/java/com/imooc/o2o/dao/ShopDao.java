package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.Shop;

public interface ShopDao {

	int insertShop(Shop shop);

	int updateShop(Shop shop);

//分页查询店铺
	/**
	 * @param shopCondition
	 * @param rowIndex从第几行开始取数据
	 * @param pageSize返回的条数
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);
	/**
	 * 返回queryShopList总数
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);

	Shop queryByShopId(long shopId);
}
