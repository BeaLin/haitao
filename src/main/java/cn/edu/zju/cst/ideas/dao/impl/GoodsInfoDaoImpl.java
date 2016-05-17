package cn.edu.zju.cst.ideas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;

import cn.edu.zju.cst.ideas.dao.IGoodsInfoDao;
import cn.edu.zju.cst.ideas.domain.Brands;
import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.domain.GoodsInfo;
import cn.edu.zju.cst.ideas.domain.Site;
import cn.edu.zju.cst.ideas.domain.Type;
import cn.edu.zju.cst.ideas.util.JdbcUtils;

@Repository(IGoodsInfoDao.SERVICE_NAME)
public class GoodsInfoDaoImpl extends BaseDaoImpl<GoodsInfo> implements IGoodsInfoDao {

	@Override
	public Goods getGoodByCode(String code) {
		Brands brands=new Brands();
		Site site=new Site();
		Type type=new Type();
		Connection con0 = null;
		ResultSet rs0 = null,rs1 = null,rs2 = null;
		try {
			con0 = JdbcUtils.getConnection();
			String sql0 = "SELECT DISTINCT(brand.goods_brand_id),goods_brand_name FROM goodsinfo,brand WHERE  goodsinfo.brand_id=brand.goods_brand_id AND goodsinfo.goods_code=? ";
			PreparedStatement pstm0 = con0.prepareStatement(sql0);
			pstm0.setString(1, code);
			rs0 = pstm0.executeQuery();
			if(rs0.next()){
				brands.setGoods_brand_id(rs0.getInt(1));
				brands.setGoods_brand_name(rs0.getString(2));
			}
			String sql1 = "SELECT DISTINCT(site.sites_id),sites_url,sites_chinese_name FROM site,goodsinfo WHERE goods_code=? AND site.sites_id=goodsinfo.sites_id";
			PreparedStatement pstm1 = con0.prepareStatement(sql1);
			pstm1.setString(1, code);
			rs1 = pstm1.executeQuery();
			if(rs1.next()){
				site.setSites_id(rs1.getInt(1));
				site.setSite_url(rs1.getString(2));
				site.setSites_chinese_name(rs1.getString(3));
			}
			
			String sql2 = "select DISTINCT(typeinfo.type_id),type_name from typeinfo,goodsinfo where goods_code=? and typeinfo.type_id=goodsinfo.type_id";
			PreparedStatement pstm2 = con0.prepareStatement(sql2);
			pstm2.setString(1, code);
			rs2 = pstm2.executeQuery();
			if(rs2.next()){
				type.setType_id(rs2.getInt(1));
				type.setType_name(rs2.getString(2));
			}
		} catch (SQLException e) {
		}finally {
			try {
				con0.close();
				rs0.close();
				rs1.close();
				rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		QueryRunner qr = new QueryRunner();
		String sql = "select * from  goodsinfo where goods_code=? ORDER BY crawling_time DESC LIMIT 1";
		Goods good = null;
		Object [] param=new Object[]{code};
		Connection  con=null;
		try {
			con = JdbcUtils.getConnection();
			good = qr.query(con,sql, new BeanHandler<Goods>(Goods.class),param);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		good.setBrands(brands);
		good.setType(type);
		good.setSite(site);
		return good;

	}

//	public Map<String, Integer> getHotBrandAndCount() {
//		Map<String, Integer> result = new HashMap<String, Integer>();
//		try {
//			Connection con = JdbcUtils.getConnection();
//			String sql = "SELECT (SELECT goods_brand_name FROM brand WHERE goods_brand_id=brand_id) AS brandname,SUM(IFNULL(month_sale_number,0)) AS number FROM goodsinfo"
//					+ " WHERE crawling_time='2015-12-17' " + " GROUP BY brand_id " + " ORDER BY number DESC "
//					+ " LIMIT 10";
//			PreparedStatement pstm = con.prepareStatement(sql);
//			ResultSet rs = pstm.executeQuery();
//			while (rs.next()) {
//				result.put(rs.getString(1), rs.getInt(2));
//			}
//
//		} catch (SQLException e) {
//			System.out.println(1);
//		}
//		return result;
//	}

	

//	public Map<Date,Float> getPriceDataByTime(String goodCode){
//		Map<Date,Float> result = new HashMap<Date,Float>();
//		Connection con = null;
//		ResultSet rs = null;
//		try {
//			con = JdbcUtils.getConnection();
//			String sql = "SELECT crawling_time,price FROM goodsinfo WHERE goods_code=?";
//			PreparedStatement pstm = con.prepareStatement(sql);
//			pstm.setString(1, goodCode);
//		    rs = pstm.executeQuery();
//			while (rs.next()) {
//				result.put(rs.getDate(1), rs.getFloat(2));
//			}
//
//		} catch (SQLException e) {
//		}finally{
//			try {
//				rs.close();
//				con.close();
//			} catch (SQLException e) {
//			}
//		}
//		return result;
//	}

	@Override
	public List<Date> getGoodSaleTimeByCode(String goodCode) {
		List<Date> timeList = new ArrayList<Date>();
		Connection con = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select distinct(crawling_time) from goodsinfo where goods_code=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, goodCode);
			rs = pstm.executeQuery();
			while (rs.next()) {
				timeList.add(rs.getDate(1));
			}

		} catch (SQLException e) {
		}finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return timeList;
	}

	@Override
	public List<Float> getPriceTrendencyByCode(String goodCode, List<Date> timeList) {
		List<Float> priceList=new ArrayList<Float>();
		Connection conn=null;
		ResultSet rs = null;
		try{
			conn=JdbcUtils.getConnection();
			String sql="select price from goodsinfo where goods_code=? and crawling_time=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			
			for (int i = 0; i < timeList.size(); i++) {
				pstm.setString(1, goodCode);
				pstm.setDate(2,new java.sql.Date(timeList.get(i).getTime()));			
				rs = pstm.executeQuery();
				if (rs.next()) {
					priceList.add(rs.getFloat(1));
				}
			}
		}catch (SQLException e) {
		}finally {		
			try {
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return priceList;
	}

	@Override
	public List<Integer> getSaleTrendencyByCode(String goodCode, List<Date> timeList) {
		List<Integer> countList=new ArrayList<Integer>();
		Connection conn=null;
		ResultSet rs = null;
		try{
			conn=JdbcUtils.getConnection();
			String sql="select month_sale_number from goodsinfo where goods_code=? and crawling_time=?";
			PreparedStatement pstm = conn.prepareStatement(sql);			
			for (int i = 0; i < timeList.size(); i++) {
				pstm.setString(1, goodCode);
				pstm.setDate(2,new java.sql.Date(timeList.get(i).getTime()));			
				rs = pstm.executeQuery();
				if (rs.next()) {
					countList.add(rs.getInt(1));
				}
			}
		}catch (SQLException e) {
		}finally {		
			try {
				conn.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return countList;
	}

	@Override
	public Map<String, Integer> getSimilarHotProduct(String goodCode) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		int brandId=getBrandByCode(goodCode);
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT goods_name,SUM(month_sale_number) AS number FROM goodsinfo WHERE brand_id=? GROUP BY goods_name ORDER BY number DESC LIMIT 10";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, brandId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.put(rs.getString(1), rs.getInt(2));
			}

		} catch (SQLException e) {
		}finally {		
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Map<String, Integer> getSimilarHotBrand(String goodCode) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		int typeId=getTypeByCode(goodCode);
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT goods_brand_name,SUM(month_sale_number) AS number FROM goodsinfo,brand WHERE type_id=? AND goodsinfo.brand_id=brand.goods_brand_id GROUP BY brand_id ORDER BY number DESC LIMIT 10";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, typeId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.put(rs.getString(1), rs.getInt(2));
			}

		} catch (SQLException e) {
		}finally {		
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Integer getBrandByCode(String goodCode) {
		Integer brandId=1;
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select distinct(brand_id) from goodsinfo where goods_code=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, goodCode);
			rs = pstm.executeQuery();
			while (rs.next()) {
				brandId=rs.getInt(1);
			}

		} catch (SQLException e) {
		}finally {		
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return brandId;
	}

	@Override
	public Integer getTypeByCode(String goodCode) {
		Integer typeId=1;
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select distinct(type_id) from goodsinfo where goods_code=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, goodCode);
			rs = pstm.executeQuery();
			while (rs.next()) {
				typeId=rs.getInt(1);
			}

		} catch (SQLException e) {
		}finally {		
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return typeId;
	}

}
