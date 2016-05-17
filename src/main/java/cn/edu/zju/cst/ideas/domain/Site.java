package cn.edu.zju.cst.ideas.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="site")
public class Site {

	@Id
	private int sites_id;
	private String sites_url;
	private String sites_logo;
	private String sites_chinese_name;
	

	public int getSites_id() {
		return sites_id;
	}

	public void setSites_id(int sites_id) {
		this.sites_id = sites_id;
	}

	public String getSite_url() {
		return sites_url;
	}

	public void setSite_url(String site_url) {
		this.sites_url = site_url;
	}

	public String getSites_logo() {
		return sites_logo;
	}

	public void setSites_logo(String sites_logo) {
		this.sites_logo = sites_logo;
	}

	public String getSites_chinese_name() {
		return sites_chinese_name;
	}

	public void setSites_chinese_name(String sites_chinese_name) {
		this.sites_chinese_name = sites_chinese_name;
	}

}
