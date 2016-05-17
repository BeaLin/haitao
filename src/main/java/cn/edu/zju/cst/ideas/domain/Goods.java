package cn.edu.zju.cst.ideas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="goodsinfo")
public class Goods {
	
	@Id
	private int goods_id;
	private String goods_name;
	
	@ManyToOne(targetEntity=Site.class)
	@JoinColumn(name="sites_id")
	private Site site;
	//private int sites_id;
	
	@ManyToOne(targetEntity=Brands.class)
	@JoinColumn(name="brand_id")
	private Brands brands;
	//private int brand_id;
	
	
	@ManyToOne(targetEntity=Type.class)
	@JoinColumn(name="type_id")
	private Type type;
	//private int type_id;
	
	private String goods_standard;
	private String producting_area;
	private String composition;
	private String use;
	private String article_number;
	private String weight;
	private String tax_rate;
	@Column(name="goods_label",length = 1024)
	private String goods_label;
	private String level_workshop_price;
	private String price;
	private String good_reputation_rating;
	private String month_sale_number;
	private String store_number;
	private String tariffs_detail;
	private String goods_picture;
	private Date crawling_time;
	private String good_keys;
	private String tag;
	private String application_people;
	@Column(name="goods_url",length = 500)
	private String goods_url;
	private String goods_code;
	

	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public Brands getBrands() {
		return brands;
	}
	public void setBrands(Brands brands) {
		this.brands = brands;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
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
	public String getLevel_workshop_price() {
		return level_workshop_price;
	}
	public void setLevel_workshop_price(String level_workshop_price) {
		this.level_workshop_price = level_workshop_price;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGood_reputation_rating() {
		return good_reputation_rating;
	}
	public void setGood_reputation_rating(String good_reputation_rating) {
		this.good_reputation_rating = good_reputation_rating;
	}
	public String getMonth_sale_number() {
		return month_sale_number;
	}
	public void setMonth_sale_number(String month_sale_number) {
		this.month_sale_number = month_sale_number;
	}
	public String getStore_number() {
		return store_number;
	}
	public void setStore_number(String store_number) {
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
	public Date getCrawling_time() {
		return crawling_time;
	}
	public void setCrawling_time(Date crawling_time) {
		this.crawling_time = crawling_time;
	}
	
	
	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", goods_name=" + goods_name + ", site=" + site.getSites_chinese_name() + ", brands=" + brands.getGoods_brand_name()
				+ ", type=" + type.getType_name() + ", goods_standard=" + goods_standard + ", producting_area=" + producting_area
				+ ", composition=" + composition + ", use=" + use + ", article_number=" + article_number + ", weight="
				+ weight + ", tax_rate=" + tax_rate + ", goods_label=" + goods_label + ", level_workshop_price="
				+ level_workshop_price + ", price=" + price + ", good_reputation_rating=" + good_reputation_rating
				+ ", month_sale_number=" + month_sale_number + ", store_number=" + store_number + ", tariffs_detail="
				+ tariffs_detail + ", goods_picture=" + goods_picture + ", crawling_time=" + crawling_time
				+ ", good_keys=" + good_keys + ", tag=" + tag + ", application_people=" + application_people
				+ ", goods_url=" + goods_url + "]";
	}	
	
}
