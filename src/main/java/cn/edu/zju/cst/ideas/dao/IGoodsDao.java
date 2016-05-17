
package cn.edu.zju.cst.ideas.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.edu.zju.cst.ideas.domain.Goods;

public interface IGoodsDao extends IBaseDao<Goods> {
	public final static String SERVICE_NAME="cn.edu.zju.cst.ideas.dao.IGoodsDao";
	
	public int getGoodsCount(int typeId);
	public int  getAveragePrice(int typeId);
	public int[] getPriceInterval();
	public int[] getProductCountByPriceInterval(int[] arr,int typeId);
	public List<Date> getSalesTime(int typeId);
	public List<Float> getPriceDataBySalesTime(int typeId,
			List<Date> timeList);
	public List<Integer> getProductCountBySalesTime(int typeId,
			List<Date> timeList);
	public Map<String, Integer> getHotProductAndCount(int typeId) ;
	public Map<String, Integer> getHotBrandAndCount(int typeId);
	
	public List<Goods> getGoodLists(String searchContext); 
	public List<Goods> getGoodListsByTypeId(int typeId);
}

