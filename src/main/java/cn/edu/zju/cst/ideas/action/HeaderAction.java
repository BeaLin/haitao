package cn.edu.zju.cst.ideas.action;

//import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import cn.edu.zju.cst.ideas.domain.Type;
import cn.edu.zju.cst.ideas.service.ITypeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class HeaderAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private List<Type> typeList;
	
	//private Long parentId;

	@Resource
	private ITypeService typeService;
	
	public ITypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(ITypeService typeService) {
		this.typeService = typeService;
	}

	public String header() {
	
		
		List<Type> typeList = typeService.findAll();
//		Map<String,Object> request =(Map<String,Object>)  ActionContext.getContext().get("request");
//		for(Type item : typeList)
//		{
//			System.out.println(item.getType_name());
//		}
		ActionContext.getContext().put("typeList", typeList);
//		request.put("typeList", typeList);
		return "header";
    }

}
