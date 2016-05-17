package cn.edu.zju.cst.ideas.domain;

public class CatagoryStatstic {
	
	private String productCount;
	private String averagePrice;
	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	private String typeName;
	
	
}
