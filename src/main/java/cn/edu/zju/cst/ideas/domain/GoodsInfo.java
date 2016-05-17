package cn.edu.zju.cst.ideas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goodsinfo")
public class GoodsInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int goods_id;

	@Column(name = "goods_name")
	private String goods_name;

	@Column(name = "sites_id")
	private int sites_id;

	@Column(name = "brand_id")
	private int brand_id;

	@Column(name = "type_id")
	private int type_id;

	@Column(name = "goods_standard")
	private String goods_standard;

	@Column(name = "producting_area")
	private String producting_area;

	@Column(name = "composition")
	private String composition;

	@Column(name = "use")
	private String use;

	@Column(name = "article_number")
	private String article_number;

	@Column(name = "weight")
	private String weight;

	@Column(name = "tax_rate")
	private String tax_rate;

	@Column(name = "goods_label")
	private String goods_label;

	@Column(name = "level_workshop_price")
	private Double level_workshop_price;

	@Column(name = "price")
	private Double price;

	@Column(name = "good_reputation_rating")
	private Double good_reputation_rating;

	@Column(name = "month_sale_number")
	private int month_sale_number;

	@Column(name = "store_number")
	private int store_number;
	
	@Column(name = "tariffs_detail")
	private String tariffs_detail;
	
	@Column(name = "goods_picture")
	private String goods_picture;
	
	@Column(name = "advantage_picture")
	private String advantage_picture;
	
	@Column(name = "voedingsinformatie_picture")
	private String voedingsinformatie_picture;
	
	@Column(name = "instructions_picture")
	private String instructions_picture;
	
	@Column(name = "authentication_picture")
	private String authentication_picture;
	
	@Column(name = "media_publicity_picture")
	private String media_publicity_picture;
	
	@Column(name = "warehouse_logistics_picture")
	private String warehouse_logistics_picture;
	
	@Column(name = "wrap_picture")
	private String wrap_picture;
	
	@Column(name = "crawling_time")
	private Date crawling_time;
	
	@Column(name = "good_keys")
	private String good_keys;
	
	@Column(name = "tag")
	private String tag;
	
	@Column(name = "application_people")
	private String application_people;
	
	@Column(name = "goods_url")
	private String goods_url;

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getSites_id() {
		return sites_id;
	}

	public void setSites_id(int sites_id) {
		this.sites_id = sites_id;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getGoods_standard() {
		return goods_standard;
	}

	public void setGoods_standard(String goods_standard) {
		this.goods_standard = goods_standard;
	}

	public String getProducting_area() {
		return producting_area;
	}

	public void setProducting_area(String producting_area) {
		this.producting_area = producting_area;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getArticle_number() {
		return article_number;
	}

	public void setArticle_number(String article_number) {
		this.article_number = article_number;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getGoods_label() {
		return goods_label;
	}

	public void setGoods_label(String goods_label) {
		this.goods_label = goods_label;
	}

	public Double getLevel_workshop_price() {
		return level_workshop_price;
	}

	public void setLevel_workshop_price(Double level_workshop_price) {
		this.level_workshop_price = level_workshop_price;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getGood_reputation_rating() {
		return good_reputation_rating;
	}

	public void setGood_reputation_rating(Double good_reputation_rating) {
		this.good_reputation_rating = good_reputation_rating;
	}

	public int getMonth_sale_number() {
		return month_sale_number;
	}

	public void setMonth_sale_number(int month_sale_number) {
		this.month_sale_number = month_sale_number;
	}

	public int getStore_number() {
		return store_number;
	}

	public void setStore_number(int store_number) {
		this.store_number = store_number;
	}

	public String getTariffs_detail() {
		return tariffs_detail;
	}

	public void setTariffs_detail(String tariffs_detail) {
		this.tariffs_detail = tariffs_detail;
	}

	public String getGoods_picture() {
		return goods_picture;
	}

	public void setGoods_picture(String goods_picture) {
		this.goods_picture = goods_picture;
	}

	public String getAdvantage_picture() {
		return advantage_picture;
	}

	public void setAdvantage_picture(String advantage_picture) {
		this.advantage_picture = advantage_picture;
	}

	public String getVoedingsinformatie_picture() {
		return voedingsinformatie_picture;
	}

	public void setVoedingsinformatie_picture(String voedingsinformatie_picture) {
		this.voedingsinformatie_picture = voedingsinformatie_picture;
	}

	public String getInstructions_picture() {
		return instructions_picture;
	}

	public void setInstructions_picture(String instructions_picture) {
		this.instructions_picture = instructions_picture;
	}

	public String getAuthentication_picture() {
		return authentication_picture;
	}

	public void setAuthentication_picture(String authentication_picture) {
		this.authentication_picture = authentication_picture;
	}

	public String getMedia_publicity_picture() {
		return media_publicity_picture;
	}

	public void setMedia_publicity_picture(String media_publicity_picture) {
		this.media_publicity_picture = media_publicity_picture;
	}

	public String getWarehouse_logistics_picture() {
		return warehouse_logistics_picture;
	}

	public void setWarehouse_logistics_picture(String warehouse_logistics_picture) {
		this.warehouse_logistics_picture = warehouse_logistics_picture;
	}

	public String getWrap_picture() {
		return wrap_picture;
	}

	public void setWrap_picture(String wrap_picture) {
		this.wrap_picture = wrap_picture;
	}

	public Date getCrawling_time() {
		return crawling_time;
	}

	public void setCrawling_time(Date crawling_time) {
		this.crawling_time = crawling_time;
	}

	public String getGood_keys() {
		return good_keys;
	}

	public void setGood_keys(String good_keys) {
		this.good_keys = good_keys;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getApplication_people() {
		return application_people;
	}

	public void setApplication_people(String application_people) {
		this.application_people = application_people;
	}

	public String getGoods_url() {
		return goods_url;
	}

	public void setGoods_url(String goods_url) {
		this.goods_url = goods_url;
	}
}
