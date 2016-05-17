package cn.edu.zju.cst.ideas.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.domain.GoodsInfo;

public interface IGoodsInfoDao extends IBaseDao<GoodsInfo> {
	public final static String SERVICE_NAME = "cn.edu.zju.cst.ideas.dao.GoodsInfoDao";
	
	public Goods getGoodByCode(String code);
	
	public List<Date> getGoodSaleTimeByCode(String goodCode);
	
	public List<Float> getPriceTrendencyByCode(String goodCode, List<Date> timeList);
	public List<Integer> getSaleTrendencyByCode(String goodCode, List<Date> timeList);
	
	public Map<String, Integer> getSimilarHotProduct(String goodCode);
	public Map<String, Integer> getSimilarHotBrand(String goodCode);
	
	public Integer getBrandByCode(String goodCode);
	public Integer getTypeByCode(String goodCode);
	
}
