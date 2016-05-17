<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/style.css" />
<title>Search Result</title>
</head>

<body>
	<!-- header part -->
	<s:action name="header" namespace="/" executeResult="true"
		ignoreContextParams="true"></s:action>
	<!-- header part finished -->

	<!-- content part -->
	<div style="width: 1000px; margin: 0 auto; margin-top: 10px;">
		<div id="content">
			<div class="product-filter column">
				<div class="limit">
					<dl class="btn-drop">
						<dt></dt>
						<dd>15</dd>
						<select onchange="location = this.value;">
							<option value="#" selected="selected">15</option>
							<option value="#">25</option>
							<option value="#">50</option>
							<option value="#">75</option>
							<option value="#">100</option>
						</select>
					</dl>
					Show:
				</div>
				<div class="sort">
					<dl class="btn-drop">
						<dt></dt>
						<dd>Default</dd>
						<select onchange="location = this.value;">
							<option value="#" selected="selected">Default</option>
							<option value="#">Name (A - Z)</option>
							<option value="#">Name (Z - A)</option>
							<option value="#">Price (Low &gt; High)</option>
							<option value="#">Price (High &gt; Low)</option>
							<option value="#">Rating (Highest)</option>
							<option value="#">Rating (Lowest)</option>
							<option value="#">Model (A - Z)</option>
							<option value="#">Model (Z - A)</option>
						</select>
					</dl>
					Sort By:
				</div>
				<div class="display">
					<div class="combo">
						<a title="List" class="view-list active"
							onclick="display('list');"><span class="icon icon-list">&nbsp;</span></a><a
							title="Grid" class="view-grid" onclick="display('grid');"><span
							class="icon icon-grid">&nbsp;</span></a>
					</div>
					Display:
				</div>
				<div class="product-compare">
					<s:a action="product" id="compare-total">Product Compare (0)</s:a>
				</div>
				<div class="clearfix"></div>
			</div>
			 <s:iterator value="goodList" id="product">
			 <div class="product-list">
				
					<div class="struct">
						<div class="line">
							<a href="<s:property value="goods_url" />" class="image-link">
								<div class="image">
									<img style="width:95%; "
										src="<s:property value="goods_picture" />"
										title="Innisfree" alt="Innisfree" />
								</div>
							</a>
							<div class="right">
								<div class="name">
								<s:a action="product.action?goodsCode=%{goods_code}"><s:property value="goods_name" /></s:a>
								</div>
								<div class="price">
									价格：<s:property value="price" />元
								</div>
								<div class="description">
								<span>品牌名称：</span>
								<s:property value="brands.goods_brand_name" />								
								<br>
								<span>来源网站：</span>
								<s:property value="site.sites_chinese_name" />
							    </div>
								<div class="cart combo">
									<s:a action="product.action?goodsCode=%{goods_code}" title="Watch the Anaylysis">
										<span class="icon icon-compare">&nbsp;</span>
									</s:a>
									<a href="<s:property value="goods_url" />" title="Go to Purchase"> <span
										class="icon icon-basket">&nbsp;</span></a> <a
										title="Add to Compare"> <span class="icon icon-wish">&nbsp;</span></a>
								</div>
							</div>														
							<div class="clearfix"></div>
						</div>

					</div>
					</div> 
				</s:iterator>
				<div class="clearfix"></div>
				<div class="column">
					<div class="pagination">
						<div class="results">Showing 1 to 6 of 6 (1 Pages)</div>
					</div>
				</div>
			
			
		</div>
	</div>
	<br>
	<!-- content part finished -->

	<!-- footer part -->
	<s:action name="footer" namespace="/" executeResult="true"
		ignoreContextParams="true"></s:action>
	<!-- footer part finished -->
</body>
</html>
