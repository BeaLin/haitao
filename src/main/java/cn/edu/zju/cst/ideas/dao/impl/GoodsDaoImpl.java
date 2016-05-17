
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

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.edu.zju.cst.ideas.dao.IGoodsDao;
import cn.edu.zju.cst.ideas.domain.Brands;
import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.util.JdbcUtils;

@Repository(IGoodsDao.SERVICE_NAME)
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements IGoodsDao {

	// 根据产品类别获取产品数量
	public int getGoodsCount(int typeId) {
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select count(*) from goodsinfo where type_id=? GROUP BY crawling_time ORDER BY crawling_time DESC LIMIT 1";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, typeId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
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

		return 0;
	}

	// 根据产品类别获取平均价格
	public int getAveragePrice(int typeId) {
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select avg(price) from goodsinfo where type_id=? GROUP BY crawling_time ORDER BY crawling_time DESC LIMIT 1";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, typeId);
			rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
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

		return 0;
	}

	// 获取价格区间（默认是5等分）
	public int[] getPriceInterval() {
		int[] arr = new int[5];
		int min = 0;
		int max = 0;

			arr[0] = 50;
			arr[1] = 100;
			arr[2] = 200;
			arr[3] = 500;
			arr[4] = 1000;
		return arr;
	}

	// 根据价格区间获取该价格区间的产品数量
	public int[] getProductCountByPriceInterval(int[] arr,int typeId) {
		int[] result = new int[6];
		Connection con=null;
		ResultSet rsmin=null,rsmax=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT COUNT(*) FROM goodsinfo WHERE  type_id=? AND price BETWEEN ? AND ? GROUP BY crawling_time ORDER BY crawling_time DESC LIMIT 1 ";
			PreparedStatement pstm = con.prepareStatement(sql);
			String sqlmin = "SELECT COUNT(*) FROM goodsinfo WHERE  type_id=? AND price <? GROUP BY crawling_time ORDER BY crawling_time DESC LIMIT 1";
			PreparedStatement pstmmin = con.prepareStatement(sqlmin);
			pstmmin.setInt(1, typeId);
			pstmmin.setInt(2, arr[0]);
			rsmin = pstmmin.executeQuery();
			if (rsmin.next()) {
				result[0] = rsmin.getInt(1);
			}

			for (int i = 0; i < 4; i++) {
				pstm.setInt(1, typeId);
				pstm.setInt(2, arr[i]);
				pstm.setInt(3, arr[i + 1]);
				ResultSet rs = pstm.executeQuery();
				if (rs.next()) {
					result[i + 1] = rs.getInt(1);
				}
			}

			String sqlmax = "SELECT COUNT(*) FROM goodsinfo WHERE  type_id=? AND price > ? GROUP BY crawling_time ORDER BY crawling_time DESC LIMIT 1";
			PreparedStatement pstmmax = con.prepareStatement(sqlmax);
			pstmmax.setInt(1, typeId);
			pstmmax.setInt(2, arr[4]);
			rsmax = pstmmax.executeQuery();
			if (rsmax.next()) {
				result[5] = rsmax.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("异常");
		}finally {
			try {
				rsmin.close();
				rsmax.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}

	// 获取销售时间点（默认是以天计）
	public List<Date> getSalesTime(int typeId) {
		List<Date> timeList = new ArrayList<Date>();
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "select distinct(crawling_time) from goodsinfo where type_id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, typeId);
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

	// 获取某个时间点某个类别的销售总数，如果typeId为0，那么就获取当天所有产品销售总数
	// 改为获取平均价格
	public List<Float> getPriceDataBySalesTime(int typeId, List<Date> timeList) {
		List<Float> countList = new ArrayList<Float>();
		Connection con=null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();

			String sql = "select avg(price) from goodsinfo where crawling_time=?";
			if (typeId != 0) {
				sql = "select avg(price) from goodsinfo where crawling_time=? and type_id=?";
			}
			PreparedStatement pstm = con.prepareStatement(sql);
			
			if (typeId != 0) {
				for (int i = 0; i < timeList.size(); i++) {
					pstm.setDate(1,
							new java.sql.Date(timeList.get(i).getTime()));
					pstm.setFloat(2, typeId);
					rs = pstm.executeQuery();
					if (rs.next()) {
						countList.add(rs.getFloat(1));
					}
				}
			} else {
				for (int i = 0; i < timeList.size(); i++) {
					pstm.setDate(1,
							new java.sql.Date(timeList.get(i).getTime()));
					rs = pstm.executeQuery();
					if (rs.next()) {
						countList.add(rs.getFloat(1));
					}
				}
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
		return countList;
	}

	// 获取某个时间点某个类别的销售总数，如果typeId为0，那么就获取当天所有产品销售总数
	public List<Integer> getProductCountBySalesTime(int typeId,
			List<Date> timeList) {
		List<Integer> countList = new ArrayList<Integer>();
		Connection con=null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getConnection();

			String sql = "select count(*) from goodsinfo where crawling_time=?";
			if (typeId != 0) {
				sql = "select count(*) from goodsinfo where crawling_time=? and type_id=?";
			}
			PreparedStatement pstm = con.prepareStatement(sql);
			
			if (typeId != 0) {
				for (int i = 0; i < timeList.size(); i++) {
					pstm.setDate(1,
							new java.sql.Date(timeList.get(i).getTime()));
					pstm.setFloat(2, typeId);
					rs = pstm.executeQuery();
					if (rs.next()) {
						countList.add(rs.getInt(1));
					}
				}
			} else {
				for (int i = 0; i < timeList.size(); i++) {
					pstm.setDate(1,
							new java.sql.Date(timeList.get(i).getTime()));
					rs = pstm.executeQuery();
					if (rs.next()) {
						countList.add(rs.getInt(1));
					}
				}
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
		return countList;
	}

	// 获取热门产品和数量（计算逻辑是按照最新一天产品的月销量来计算的）
	public Map<String, Integer> getHotProductAndCount(int typeId) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT  goods_name,IFNULL(month_sale_number,0) AS number FROM goodsinfo WHERE type_id=? AND crawling_time='2015-12-28'"+
" ORDER BY number DESC LIMIT 10 ";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, typeId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.put(rs.getString(1), rs.getInt(2));
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
		return result;
	}

	// 获取热门品牌和数量（计算逻辑是按照最新一天产品的月销量来计算的）
	/*
	 * 测试用的因为最新的时间的数据有可能没有上传 SELECT (SELECT goods_brand_name FROM brand WHERE
	 * goods_brand_id=brand_id) AS brandname,SUM(IFNULL(month_sale_number,0)) AS
	 * number FROM goodsinfo WHERE crawling_time='2015-12-17' GROUP BY brand_id
	 * ORDER BY number DESC LIMIT 10
	 * 
	 * 正式 SELECT (SELECT goods_brand_name FROM brand WHERE
	 * goods_brand_id=brand_id) AS brandname,SUM(IFNULL(month_sale_number,0)) AS
	 * number FROM goodsinfo WHERE crawling_time=( SELECT MIN(crawling_time)
	 * FROM goodsinfo) GROUP BY brand_id ORDER BY number DESC LIMIT 10
	 */
	public Map<String, Integer> getHotBrandAndCount(int typeId) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		Connection con=null;
		ResultSet rs=null;
		try {
			con = JdbcUtils.getConnection();
			String sql = "SELECT (SELECT goods_brand_name FROM brand WHERE goods_brand_id=brand_id) AS brandname,"
					+ " SUM(IFNULL(month_sale_number,0)) AS number  "
					+ " FROM goodsinfo WHERE type_id=? AND "
					+ " crawling_time=( SELECT MIN(crawling_time) FROM goodsinfo) "
					+ " GROUP BY brand_id ORDER BY number DESC LIMIT 10";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, typeId);
			rs = pstm.executeQuery();
			while (rs.next()) {
				result.put(rs.getString(1), rs.getInt(2));
			}

		} catch (SQLException e) {
			System.out.println(1);
		}finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return result;
	}

	
	@Override
	public List<Goods> getGoodLists(String searchContext) {
		@SuppressWarnings("unchecked")
		List<Goods> goodLists = getSession().createQuery("from Goods where good_keys like :searchContext and crawling_time='2015-12-29'")
					.setString("searchContext", "%" + searchContext + "%")
					.setMaxResults(60)
					.list();
		return goodLists;
	}

	@Override
	public List<Goods> getGoodListsByTypeId(int typeId) {
		@SuppressWarnings("unchecked")
		List<Goods> goodLists = getSession().createQuery("from Goods where type_id like :typeId and crawling_time='2015-12-29'")
					.setInteger("typeId", typeId)
					.setMaxResults(60)
					.list();
		return goodLists;
	}
}
