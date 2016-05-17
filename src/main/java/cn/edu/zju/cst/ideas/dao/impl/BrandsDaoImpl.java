package cn.edu.zju.cst.ideas.dao.impl;

import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.IBrandsDao;
import cn.edu.zju.cst.ideas.domain.Brands;

@Repository(IBrandsDao.SERVICE_NAME)
public class BrandsDaoImpl extends BaseDaoImpl<Brands> implements IBrandsDao{

}
