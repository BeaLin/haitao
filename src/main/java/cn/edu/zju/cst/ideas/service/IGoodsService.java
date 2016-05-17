package cn.edu.zju.cst.ideas.service;

import java.util.List;
import java.util.Map;

import cn.edu.zju.cst.ideas.domain.CatagoryStatstic;
import cn.edu.zju.cst.ideas.domain.Goods;

public interface IGoodsService  {
	
	public int getGoodsCount(int typeId);
	public int getAveragePrice(int typeId);
	public CatagoryStatstic getCatagoryStatstic(int typeId);
	public String getGoodsJson(int typeId);
	public String getGoodsJson();
	public List<Goods> getGoodLists(String searchContext);
	public List<Goods> getGoodListsByTypeId(int typeId);
	public Map<Integer, String> getGoodsJson(List<Goods> goodList);
	Map<Integer, String> getGoodsPic(List<Goods> goodsList);
}

