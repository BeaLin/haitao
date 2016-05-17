package cn.edu.zju.cst.ideas.test;



import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.edu.zju.cst.ideas.dao.impl.GoodsDaoImpl;
import cn.edu.zju.cst.ideas.dao.impl.GoodsInfoDaoImpl;
import cn.edu.zju.cst.ideas.service.impl.GoodsService;

public class TestDemo {
	
	@Test
	public void  test1()
	{
		GoodsDaoImpl dao = new GoodsDaoImpl();
		int result = dao.getGoodsCount(2);
		int result2 = dao.getAveragePrice(2);
		System.out.println(result);
		System.out.println(result2);
	}
	
	@Test
	public void test2()
	{
		java.util.Date date1=new java.util.Date(15,10,24);
		java.util.Date date2=new java.util.Date(115,10,24);
		java.sql.Date date3 = new java.sql.Date(date1.getTime());
		System.out.println("date1:"+date1.toString());
		System.out.println("date2:"+date2.toString());
		System.out.println("date3:"+date3.toString());
		System.out.println("date1==date2"+date1.compareTo(date2));
		System.out.println("date1==date3"+date1.compareTo(date3));
		
	}
	
	@Test
	public void test3() throws ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		GoodsDaoImpl dao = new GoodsDaoImpl();
		List<Date> timeList = new ArrayList<Date>();
		timeList.add(format.parse("2015-12-16"));
		timeList.add(format.parse("2015-12-17"));
		timeList.add(format.parse("2015-12-18"));
		timeList.add(format.parse("2015-12-19"));
		timeList.add(format.parse("2015-12-20"));
		//List<Integer> count =dao.getPriceDataBySalesTime(0, timeList);
		Date date1 =format.parse("2015-10-24");
		//System.out.println(date1.toString());
//		for(int i:count){
//			System.out.println(i);
//		}
	}
	
	@Test
	public void test4()
	{
		GoodsService service = new GoodsService();
		GoodsDaoImpl dao = new GoodsDaoImpl();
		service.setGoodsDao(dao);
		
		String result = service.getGoodsJson();
		System.out.println(result);
		
	}
	
	
	@Test
	public void test41()
	{
		List<Float> list =new ArrayList<Float>();
		list.add((float) 242.5526);
		list.add((float) 153.16959);
		list.add((float) 206.73465);
		
		List<Float> list1 =new ArrayList<Float>();
		
		for(Float item:list)
		{
		   BigDecimal b = new BigDecimal(item);
		   item = b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
		   list1.add(item);
		}		
		
		for(Float item:list1)
		{
			System.out.println(item);
		}
	}
	
	@Test
	public void test5()
	{
		GoodsDaoImpl dao = new GoodsDaoImpl();
		Map<String,Integer> map=dao.getHotBrandAndCount(2);
		
		for(Map.Entry<String, Integer> entry:map.entrySet())
		{
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		}
	}
	
	@Test
	public void test6()
	{
		GoodsService service = new GoodsService();
		GoodsDaoImpl dao = new GoodsDaoImpl();
		service.setGoodsDao(dao);
		
	//	String result = service.getGoodsJson(2);
		
		Map<String,Integer> map = dao.getHotBrandAndCount(2);
		for(Map.Entry<String, Integer> entry:map.entrySet())
		{
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue()); 
		}
		
		//System.out.println(service.getTypeName(2));
		
		//CatagoryStatstic demo = service.getCatagoryStatstic(2);
		//System.out.println(demo.getAveragePrice());
		
	}
	
	
	@Test
	public void test7()
	{
		GoodsService service = new GoodsService();
		GoodsDaoImpl dao = new GoodsDaoImpl();
		service.setGoodsDao(dao);
		
		List<Date> datelist = dao.getSalesTime(2);
		for(Date date :datelist)
		{
			System.out.println(date.toString());
		}
	
	}
	
	@Test
	public void test8()
	{
		GoodsService service = new GoodsService();
		GoodsDaoImpl dao = new GoodsDaoImpl();
		service.setGoodsDao(dao);
		
		int[] arr = new int[5];
		arr[0]=50;
		arr[1]=100;
		arr[2]=200;
		arr[3]=500;
		arr[4]=1000;
		
		int[] arr1 = dao.getProductCountByPriceInterval(arr,2);
		for(int i : arr1){
			System.out.println(i);
		}
	}
	
	@Test
	public void test9(){
		//GoodsInfoService service = new GoodsInfoService();
		GoodsInfoDaoImpl dao = new GoodsInfoDaoImpl();
		System.out.println(dao.getGoodByCode("om102122").getGoods_id());
	}
	
	
	@Test
	public void test10(){
		//GoodsInfoService service = new GoodsInfoService();
		GoodsDaoImpl dao = new GoodsDaoImpl();
		System.out.println(dao.getAveragePrice(4));
	}
	
	
}
