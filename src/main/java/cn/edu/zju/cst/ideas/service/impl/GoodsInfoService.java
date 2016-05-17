package cn.edu.zju.cst.ideas.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

import cn.edu.zju.cst.ideas.dao.IGoodsInfoDao;
import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.service.IGoodsInfoService;
import cn.edu.zju.cst.ideas.service.IGoodsService;

@Repository
public class GoodsInfoService extends BaseService<Goods> implements IGoodsInfoService{
	
	@Resource
	private IGoodsInfoDao goodsInfoDao;

	public IGoodsInfoDao getGoodsDao() {
		return goodsInfoDao;
	}

	public void setGoodsDao(IGoodsInfoDao goodsInfoDao) {
		this.goodsInfoDao = goodsInfoDao;
	}

	@Override
	public Goods getGoodByCode(String code) {
		return goodsInfoDao.getGoodByCode(code);
	}

	@Override
	public String getGoodsJson(String goodCode) {
		JSONObject jo = new JSONObject();
		System.out.println("start::");
		List<Date> priceTime=goodsInfoDao.getGoodSaleTimeByCode(goodCode);
		List<String> FpriceTime = new ArrayList<String>();
		for(Date date:priceTime)
		{
			FpriceTime.add(date.toString());
		}
		List<Float> priceData =goodsInfoDao.getPriceTrendencyByCode(goodCode, priceTime);
		List<Float> FpriceData = new ArrayList<Float>();
		
		for(Float item:priceData)
		{
		   BigDecimal b = new BigDecimal(item);
		   item = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		   FpriceData.add(item);
		}
		
		List<Date> salesTime=priceTime;
		List<Integer> salesData =goodsInfoDao.getSaleTrendencyByCode(goodCode, salesTime);
		
		Map<String,Integer> hosProductMap = goodsInfoDao.getSimilarHotProduct(goodCode);
		Object[] productName = hosProductMap.keySet().toArray();
		Object[] productSales =hosProductMap.values().toArray();
		Map<String,Integer> hotBrandMap = goodsInfoDao.getSimilarHotBrand(goodCode);
		Object[] brandName= hotBrandMap.keySet().toArray();
		Object[] brandSales = hotBrandMap.values().toArray();
		jo.put("priceTime", FpriceTime);
		jo.put("priceData", FpriceData);
		jo.put("salesTime",FpriceTime);
		jo.put("salesData",salesData);
		jo.put("productName",productName);
		jo.put("productSales", productSales);
		jo.put("brandName", brandName);
		jo.put("brandSales", brandSales);
		System.out.println("JsonStr:"+jo.toJSONString());
		return jo.toJSONString();
		
	}
	
}
