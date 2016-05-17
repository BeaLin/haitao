package cn.edu.zju.cst.ideas.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.IBrandsDao;
import cn.edu.zju.cst.ideas.domain.Brands;
import cn.edu.zju.cst.ideas.service.IBrandsService;

@Repository
public class BrandsService extends BaseService<Brands> implements IBrandsService{
	@Resource
	private IBrandsDao brandDao;

	public IBrandsDao getBrandDao() {
		return brandDao;
	}

	public void setBrandDao(IBrandsDao brandDao) {
		this.brandDao = brandDao;
	}
}
