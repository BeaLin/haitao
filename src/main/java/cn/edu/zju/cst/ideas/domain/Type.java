package cn.edu.zju.cst.ideas.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="typeinfo")
public class Type {

	@Id
	private int type_id;
	
	private String type_name;

	@OneToMany(targetEntity=Goods.class)
	private List<Goods> goodList;
	
	public List<Goods> getGoodList() {
		return goodList;
	}

	public void setGoodList(List<Goods> goodList) {
		this.goodList = goodList;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
}
