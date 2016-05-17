<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/css/style.css" />
<title>Categories Analysis</title>
</head>
<body>
	<!-- header part -->
	<s:action name="header" namespace="/" executeResult="true"
		ignoreContextParams="true"></s:action>
	<!-- header part finished -->
	<div style="width: 1000px; margin: 0 auto; margin-top: 10px;">
		<div class="linktree">
			<a href="#">Home</a> &raquo; <a href="#"><s:property value="type.type_name"/></a>
		</div>
		<br>
		<h1 style="margin-top: -10px;"><s:property value="goods_name"/></h1>
		<br>
		<div id="notification"></div>
		<script type="text/javascript" src="<%=basePath%>/js/echarts.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.1.min.js" ></script>
		<script type="text/javascript">
		function createRandomItemStyle() {
		    return {
		        normal: {
		            color: 'rgb(' + [
		                Math.round(Math.random() * 160),
		                Math.round(Math.random() * 160),
		                Math.round(Math.random() * 160)
		            ].join(',') + ')'
		        }
		    };
		}
			require.config({
				paths : {
					echarts : '<%=basePath%>/js/dist'
				}
			});
			require([ 'echarts', 'echarts/chart/line', 'echarts/chart/bar',
					'echarts/chart/wordCloud' ],
			//渲染ECharts图表  
			function DrawEChart(ec) {
				var priceTrendChart = ec.init(document
						.getElementById('price-trend'));
				priceTrendChart.showLoading({  
	                text : "图表数据正在努力加载..."  
	            }); 
				var priceTrendOption = {
					title : {
						text : '产品历史价格走势'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '价格' ]
					},
					toolbox : {
						show : true,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'line', 'bar' ]
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value} 元'
						}
					} ],
					series : [ {
						name : '产品价格',
						type : 'line',
						data : [ 110, 110, 120, 120, 110, 150, 110 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最高价格'
							}, {
								type : 'min',
								name : '最低价格'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均价格'
							} ]
						}
					} ]
				};

				

				//销量走势图
				var salesTrendChart = ec.init(document
						.getElementById('sales-trend'));
				salesTrendChart.showLoading({  
	                text : "图表数据正在努力加载..."  
	            }); 
				var salesTrendOption = {
					title : {
						text : '产品销量走势'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '产品销量' ]
					},
					toolbox : {
						show : true,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'line', 'bar' ]
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value}'
						}
					} ],
					series : [ {
						name : '产品销量',
						type : 'line',
						data : [ 480, 485, 494, 494, 515, 540, 555 ],

					} ]
				};
				var productRecommendChart = ec.init(document.getElementById('product-recommend'));
				productRecommendChart.showLoading({  
	                text : "图表数据正在努力加载..."  
	            }); 
				var productRecommendOption = {
					title : {
						text : '产品推荐'
					},
					tooltip : {
						show : true
					},
					series : [ {
						name : '产品推荐',
						type : 'wordCloud',
						size : [ '80%', '80%' ],
						textRotation : [ 0, 45, 90, -45 ],
						textPadding : 0,
						autoSize : {
							enable : true,
							minSize : 14
						},
						data : [ {
							name : "芦荟胶",
							value : 70,
							itemStyle : {
								normal : {
									color : 'black'
								}
							}
						}, {
							name : "Innisfree洁面奶",
							value : 11,
							itemStyle : createRandomItemStyle()
						}, {
							name : "花印美白精华",
							value : 4,
							itemStyle : createRandomItemStyle()
						}, {
							name : "保水面膜",
							value : 5,
							itemStyle : createRandomItemStyle()
						}, {
							name : "气垫bb",
							value : 17,
							itemStyle : createRandomItemStyle()
						}, {
							name : "补水保湿霜",
							value : 2244,
							itemStyle : createRandomItemStyle()
						}, {
							name : "去角质膏",
							value : 18,
							itemStyle : createRandomItemStyle()
						}, {
							name : "一叶子面膜",
							value : 14,
							itemStyle : createRandomItemStyle()
						}, {
							name : "身体乳",
							value : 12,
							itemStyle : createRandomItemStyle()
						}, {
							name : "护发素",
							value : 9,
							itemStyle : createRandomItemStyle()
						} ]
					} ]
				};
				var brandProductChart = ec.init(document
						.getElementById('brand_product'));
				brandProductChart.showLoading({  
	                text : "图表数据正在努力加载..."  
	            }); 
				var brandProductOption = {
					title : {
						text : '品牌推荐'
					},
					tooltip : {
						show : true
					},
					series : [ {
						name : '同类型品牌推荐',
						type : 'wordCloud',
						size : [ '80%', '80%' ],
						textRotation : [ 0, 45, 90, -45 ],
						textPadding : 0,
						autoSize : {
							enable : true,
							minSize : 14
						},
						data : [ {
							name : "Innisfree芦荟胶",
							value : 9,
							itemStyle : {
								normal : {
									color : 'black'
								}
							}
						}, {
							name : "Innisfree洁面奶",
							value : 6,
							itemStyle : createRandomItemStyle()
						}, {
							name : "花印",
							value : 4,
							itemStyle : createRandomItemStyle()
						}, {
							name : "兰蔻",
							value : 5,
							itemStyle : createRandomItemStyle()
						}, {
							name : "美宝莲",
							value : 7,
							itemStyle : createRandomItemStyle()
						}, {
							name : "资生堂",
							value : 14,
							itemStyle : createRandomItemStyle()
						}, {
							name : "比度克",
							value : 18,
							itemStyle : createRandomItemStyle()
						}, {
							name : "一叶子",
							value : 14,
							itemStyle : createRandomItemStyle()
						}, {
							name : "玛丽黛佳",
							value : 12,
							itemStyle : createRandomItemStyle()
						}, {
							name : "护发素",
							value : 5,
							itemStyle : createRandomItemStyle()
						} ]
					} ]
				};
				var url='${pageContext.request.contextPath}/jsonProduct.action?goodsCode=<%=request.getAttribute("goodsCode")%>';
					$.ajax({  
	                	type : "post",  
	                	async : false, //同步执行  
	                	url : url, 
	                	dataType : "json", //返回数据形式为json  
	                	success : function(result) {  
	                    	if (result) {  
	                    		priceTrendOption.xAxis[0].data = result.priceTime;  
	                    		priceTrendOption.series[0].data = result.priceData;
	                    		salesTrendOption.xAxis[0].data = result.salesTime;  
	                    		salesTrendOption.series[0].data = result.salesData;
	                    	
	                    		for(var i=0;i<result.productName.length;i++){
	                    			productRecommendOption.series[0].data[i].name=result.productName[i].substring(0,10);
		                    		productRecommendOption.series[0].data[i].value=result.productSales[i];
	                    		}
	                    	
	                    		for(var i=0;i<result.brandName.length;i++){
	                    			brandProductOption.series[0].data[i].name=result.brandName[i];
	                    			brandProductOption.series[0].data[i].value=result.brandSales[i];
	                    		}
	                    	 
	                    		priceTrendChart.hideLoading();  
	                    		priceTrendChart.setOption(priceTrendOption); 
	                    		salesTrendChart.hideLoading();  
	                    		salesTrendChart.setOption(salesTrendOption);
	                    		productRecommendChart.hideLoading();  
	                    		productRecommendChart.setOption(productRecommendOption);
	                    		brandProductChart.hideLoading();  
	                    		brandProductChart.setOption(brandProductOption);
	                    	}  
	                	},  
	                	error : function(errorMsg) {  
	                    	alert("不好意思，大爷，图表请求数据失败啦!");  
	                    	priceTrendChart.hideLoading();
	                    	salesTrendChart.hideLoading();
	                    	productRecommendChart.hideLoading();
	                    	brandProductChart.hideLoading();
	                	}  
	            	});  
				});
		</script>
		<div id="column-left">
			<div class="box" id="box-menufix">
				<div class="box-heading_left">分析内容</div>
				<div class="box-content" style="background: none; border: none;">
					<div class="box-category">
						<ul>
							<li><a href="#product-deatail">商品信息</a>
							<li><a href="#price-trend">价格走势</a>
							<li><a href="#sales-trend">销量走势</a></li>
							<li><a href="#product-recommend">同品牌产品推荐</a></li>
							<li><a href="#bland-product">同类型品牌推荐</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<div id="content">
			<div class="content-title">商品信息</div>
			<div class="category-info" id="product-detail">
				<div class="product-name">
					<span><s:property value="brands.goods_brand_name"/></span>&nbsp;&nbsp;/&nbsp;&nbsp;<s:property value="goods_name"/>
				</div>
				<div class="image">
					<img style="width:103%; " src="<s:property value="goods_picture" />" alt="Product" />
				</div>
				<div class="product-moredetail">
					类别：<s:property value="type.type_name"/> <br>
					<hr style="border: 1px dotted #ccc" />
					<br> <span style="font-size: 20px; color: #e83d02;">价格：<s:property value="level_workshop_price"/></span>&nbsp;&nbsp;&nbsp;&nbsp;
					<del style="font-size: 17px"><s:property value="price"/></del>
					<br>
					<hr style="border: 1px dotted #ccc" />
					<br> 已购买人数:&nbsp;&nbsp;<span style="color: #e83d02;"><s:property value="month_sale_number"/>人</span>&nbsp;&nbsp;(<s:property value="good_reputation_rating"/>分)
					<br>
					<hr style="border: 1px dotted #ccc" />
					<br>发货形式：<span style="color: #999999;"><s:property value="tag"/></span>
					<br>货品编号：<span style="color: #999999;"><s:property value="article_number"/> </span>
					<br>适用人群：<span style="color: #999999;"><s:property value="application_people"/> </span>
					<br>规格&nbsp;&nbsp;：<span style="color: #999999;"><s:property value="goods_standard"/></span>
					<br>生产地&nbsp;&nbsp;：<span style="color: #999999;"><s:property value="producting_area"/> </span>
					<br>组成成分：<span style="color: #999999;"><s:property value="composition"/> </span>
					<br>来源网站：<span style="color: #999999;"><s:property value="site.sites_chinese_name"/></span>
					<br>税率&nbsp;&nbsp;：<span style="color: #999999;"><s:property value="tax_rate"/></span>
					<br>税收明细：<span style="color: #999999;"><s:property value="tariffs_detail"/></span>
					<br>商品标签：<span style="color: #999999;"><s:property value="goods_label"/></span>
					<br>
					<hr style="border: 1px dotted #ccc" />
					<br>
					<div class="purchase-button">
						<a href="<s:property value="goods_url"/>" class="button" id="purchase-button1"><span>点击前往购买</span></a>
					</div>

				</div>
			</div>
			<div class="content-title">价格走势</div>
			<div class="category-info" id="price-trend"
				style="height: 400px; width: 775px;"></div>
			<div class="content-title">销量走势</div>
			<div class="category-info" id="sales-trend"
				style="height: 400px; width: 775px;"></div>
			<div class="content-title">同品牌产品推荐</div>
			<div class="category-info" id="product-recommend"
				style="height: 400px; width: 775px;"></div>
			<div class="content-title">同类型品牌推荐</div>
			<div class="category-info" id="brand_product"
				style="height: 400px; width: 775px;"></div>
			<div class="clearfix"></div>

		</div>

	</div>

	<!-- footer part -->
	<s:action name="footer" namespace="/" executeResult="true"
		ignoreContextParams="true"></s:action>
	<!-- footer part finished -->
</body>
</html>