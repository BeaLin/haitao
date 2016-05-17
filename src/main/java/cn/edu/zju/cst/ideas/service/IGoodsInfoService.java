package cn.edu.zju.cst.ideas.service;

import cn.edu.zju.cst.ideas.domain.Goods;

public interface IGoodsInfoService  {
	public Goods getGoodByCode(String code);
	public String getGoodsJson(String goodCode);
}

