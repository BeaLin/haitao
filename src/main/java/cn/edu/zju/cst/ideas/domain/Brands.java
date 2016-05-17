package cn.edu.zju.cst.ideas.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class Brands {

	@Id
	private int goods_brand_id;
	
	private String goods_brand_name;
	public int getGoods_brand_id() {
		return goods_brand_id;
	}
	public void setGoods_brand_id(int goods_brand_id) {
		this.goods_brand_id = goods_brand_id;
	}
	public String getGoods_brand_name() {
		return goods_brand_name;
	}
	public void setGoods_brand_name(String goods_brand_name) {
		this.goods_brand_name = goods_brand_name;
	}
	

	
}
