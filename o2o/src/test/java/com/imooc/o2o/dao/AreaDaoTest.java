package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.BaseTest;

public class AreaDaoTest extends BaseTest{
   @Autowired
private AreaDao areaDao;
   @Test
   public void testQueryArea() {
	   List<Area> areaList=areaDao.queryArea();
	   assertEquals(2, areaList.size());
   }
}
