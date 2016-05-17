package cn.edu.zju.cst.ideas.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	private int comment_id;
	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public int getGood_id() {
		return good_id;
	}

	public void setGood_id(int good_id) {
		this.good_id = good_id;
	}

	private int goods_id;
	private int good_id;
	private Date comments_time;
	private Date crawling_time;
	private String comments_content;
	private String user_type;

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public int getGoos_id() {
		return goods_id;
	}

	public void setGoos_id(int goos_id) {
		this.goods_id = goos_id;
	}

	public Date getComments_time() {
		return comments_time;
	}

	public void setComments_time(Date comments_time) {
		this.comments_time = comments_time;
	}

	public Date getCrawling_time() {
		return crawling_time;
	}

	public void setCrawling_time(Date crawling_time) {
		this.crawling_time = crawling_time;
	}

	public String getComments_content() {
		return comments_content;
	}

	public void setComments_content(String comments_content) {
		this.comments_content = comments_content;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

}
