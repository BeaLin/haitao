package cn.edu.zju.cst.ideas.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.service.IGoodsInfoService;

public class ProductAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String goodsCode;
	@Resource
	private IGoodsInfoService goodInfoService;

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String product() throws IOException {
		System.out.println("goodsCode:"+goodsCode);
		Goods goodInfo = goodInfoService.getGoodByCode(goodsCode);
//		ActionContext.getContext().put("goodInfo", goodInfo);
		ActionContext.getContext().getValueStack().push(goodInfo);
//		System.out.print("productDetail:"+productDetail);
		return "product";
	}
	
	public String productJson() throws IOException{
		System.out.print("jsonStr~~~");
		String jsonStr=goodInfoService.getGoodsJson(goodsCode);
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext().get(ServletActionContext.HTTP_RESPONSE); 
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonStr);
		System.out.print("jsonStr:"+jsonStr);
		return null;
	}
}
