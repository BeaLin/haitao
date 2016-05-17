package cn.edu.zju.cst.ideas.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

import cn.edu.zju.cst.ideas.dao.IGoodsDao;
import cn.edu.zju.cst.ideas.dao.ITypeDao;
import cn.edu.zju.cst.ideas.dao.impl.TypeDaoImpl;
import cn.edu.zju.cst.ideas.domain.CatagoryStatstic;
import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.domain.Type;
import cn.edu.zju.cst.ideas.service.IGoodsService;

@Repository
public class GoodsService extends BaseService<Goods> implements IGoodsService{
	
	@Resource
	private IGoodsDao goodsDao;
	@Resource
	private ITypeDao typeDao;
	
	public IGoodsDao getGoodsDao() {
		return goodsDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public int getGoodsCount(int typeId) {
		return goodsDao.getGoodsCount(typeId);
	}

	@Override
	public int getAveragePrice(int typeId) {
		return goodsDao.getAveragePrice(typeId);
	}
	
	 public String getTypeName(int typeId)
	{
		 if(typeDao ==null)typeDao = new TypeDaoImpl();
		 String aa= typeDao.getTypeName(typeId);
		// System.out.println(type);
		return aa;
	}
	 
	public CatagoryStatstic getCatagoryStatstic(int typeId)
	{
		CatagoryStatstic result = new CatagoryStatstic();
		result.setProductCount(getGoodsCount(typeId)+"");
		result.setAveragePrice(getAveragePrice(typeId)+"");
		result.setTypeName(getTypeName(typeId));
		return result;
	}

	@Override
	public String getGoodsJson(int typeId) {
		JSONObject jo = new JSONObject();
		String[] priceInterval = new String[5];
		int[] priceIntemp=goodsDao.getPriceInterval();
		for(int i=0;i<=priceIntemp.length-1;i++){
			if(i==0)
			{
				priceInterval[i]=priceIntemp[i]+"";
				continue;
			}else if(i==priceIntemp.length-1)
			{
				priceInterval[i] = priceIntemp[i]+"";
				break;
			}
			priceInterval[i]=priceIntemp[i]+"-"+priceIntemp[i+1];
		}
		int[] productCount=goodsDao.getProductCountByPriceInterval(priceIntemp,typeId);
		List<Date> priceTime=goodsDao.getSalesTime(typeId) ;
		List<String> FpriceTime = new ArrayList<String>();
		for(Date date:priceTime)
		{
			FpriceTime.add(date.toString());
		}
		List<Float> priceData =goodsDao.getPriceDataBySalesTime(typeId, priceTime);
		List<Float> FpriceData = new ArrayList<Float>();
		
		for(Float item:priceData)
		{
		   BigDecimal b = new BigDecimal(item);
		   item = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		   FpriceData.add(item);
		}
		
		List<Date> salesTime=priceTime;
		List<Integer> salesData =goodsDao.getProductCountBySalesTime(typeId, salesTime);
		
		Map<String,Integer> hosProductMap = goodsDao.getHotProductAndCount(typeId);
		Object[] productName = hosProductMap.keySet().toArray();
		Object[] productSales =hosProductMap.values().toArray();
		Map<String,Integer> hotBrandMap = goodsDao.getHotBrandAndCount(typeId);
		Object[] brandName= hotBrandMap.keySet().toArray();
		Object[] brandSales = hotBrandMap.values().toArray();
		
		jo.put("priceInterval", priceInterval);
		jo.put("productCount", productCount);
		jo.put("priceTime", FpriceTime);
		jo.put("priceData", FpriceData);
		jo.put("salesTime",FpriceTime);
		jo.put("productSales",salesData);
		jo.put("productName",productName);
		jo.put("productCount", productSales);
		jo.put("brandName", brandName);
		jo.put("brandSales", brandSales);
		System.out.println("catagoryJson:"+jo.toJSONString());
		return jo.toJSONString();
	}

	@Override
	public String getGoodsJson() {
		return getGoodsJson(0);
	}
	
	@Override
	public List<Goods> getGoodLists(String searchContext) {
		List<Goods> goodLists = goodsDao.getGoodLists(searchContext);
		return goodLists;
	}
	@Override
	public Map<Integer, String> getGoodsPic(List<Goods> goodsList) {
		Map<Integer,String> goods_img = new HashMap<>();
		for(Goods good : goodsList){
			String[] arr = good.getGoods_picture().split("/");
			String img = good.getSite().getSites_id() + "/" + arr[arr.length - 1];
			goods_img.put(good.getGoods_id(), img);
		}
		return goods_img;
	}

	@Override
	public Map<Integer, String> getGoodsJson(List<Goods> goodList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> getGoodListsByTypeId(int typeId) {
		List<Goods> goodLists = goodsDao.getGoodListsByTypeId(typeId);
		return goodLists;
	}
}
