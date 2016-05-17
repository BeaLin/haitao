package cn.edu.zju.cst.ideas.action;

import java.awt.SystemTray;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;

import cn.edu.zju.cst.ideas.domain.CatagoryStatstic;
import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.service.IGoodsService;


public class CategoryAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int typeId;

	@Resource
	private IGoodsService goodService;
	
	
	public String category() throws IOException{
		
		CatagoryStatstic category = goodService.getCatagoryStatstic(typeId);
		List<Goods> productList = goodService.getGoodListsByTypeId(typeId);
		ActionContext.getContext().getValueStack().push(category);
		ActionContext.getContext().put("productList", productList);
		System.out.println(typeId);
		return "category";
	}

	public String categoryJson() throws IOException{
		
		String jsonString = goodService.getGoodsJson(typeId);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonString);
		return null;
	}
	
	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
