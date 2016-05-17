package cn.edu.zju.cst.ideas.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.zju.cst.ideas.domain.Goods;
import cn.edu.zju.cst.ideas.service.IGoodsService;

public class SearchAction extends ActionSupport{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private String searchContext;
	
	@Resource
	private IGoodsService goodService;
	
	public String getSearchContext() {
		return searchContext;
	}
	public void setSearchContext(String searchContext) {
		this.searchContext = searchContext;
	}
	public String search() {
        System.out.print("searchContext"+searchContext);
        List<Goods> goodList = goodService.getGoodLists(searchContext);
        Map<Integer, String> goods_pic = goodService.getGoodsJson(goodList);
        
        
//        ActionContext actionContext=ActionContext.getContext();
//		HttpServletRequest request=(HttpServletRequest)actionContext.get(ServletActionContext.HTTP_REQUEST);
//        request.setAttribute("goodList",goodList);
        
        
//        System.out.println(goodList.get(1));
        ActionContext.getContext().put("goodList", goodList);
        ActionContext.getContext().put("goods_pic", goods_pic);
//        ActionContext.getContext().getValueStack().push(goods_pic);
		return "search";
    }

}
