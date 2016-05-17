<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
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
			<a href="#">首页</a> &raquo; <a href="#">面部护肤</a>&raquo; <a href="#">面膜</a>
		</div>
		<br>
		<h1 style="margin-top: -10px;">面膜</h1>
		<br>
		<div id="notification"></div>
		<div id="column-left">
			<div class="box">
				<div class="box-heading_left">分析内容</div>
				<div class="box-content" style="background: none; border: none;">
					<div class="box-category">
						<ul>
							<li><a href="#price-distribute">基本统计</a></li>
							<li><a href="#price-distribute">价格分布</a></li>
							<li><a href="#price-tredn">价格走势</a></li>
							<li><a href="#sales-trend">销量走势</a></li>
							<li><a href="#product-recommend">热门产品排行榜</a></li>
							<li><a href="#bland-recommend">热门品牌排行榜</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.1.min.js" ></script>
		<script type="text/javascript" src="<%=basePath%>/js/echarts.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/tab.js"></script>
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
				
				var priceDistributeChart = ec.init(document
						.getElementById("price-distribute"));
				priceDistributeChart.showLoading({
					text : "图表数据正在努力加载..."
				});
				//加载图表  
				var priceDistributeOption = {
					title : {
						text : '面膜类产品的价格分布'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '产品个数' ]
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
					calculable : true,
					xAxis : [ {
						type : 'category',
						data : [ '50元以下', '50元-100元', '100元-150元', '150元-200元',
								'200元-250元', '250元-300元', '300元以上' ]
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						name : '产品个数',
						type : 'bar',
						data : [ 20, 149, 170, 123, 75, 37, 13 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						}
					} ]
				};
				//图表渲染的容器对象  
				var priceTrendChart = ec.init(document
						.getElementById("price-trend"));
				priceTrendChart.showLoading({
					text : "图表数据正在努力加载..."
				});
				//加载图表  
				var priceTrendOption = {
					title : {
						text : '价格走势'
					},
					tooltip : {
						trigger : 'axis'//item  axis  
					},
					legend : {
						data : [ '平均价格' ]
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
					calculable : true,
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '10/16', '10/17', '10/18', '10/19', '10/20',
								'10/21', '10/22' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value}元'
						},
						splitNumber : 10
					} ],
					series : [ {
						name : '平均价格',
						type : 'line',
						data : [ 89, 91, 91, 89, 92, 91, 90 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					} ]
				};
				var salesTrendChart = ec.init(document
						.getElementById("sales-trend"));
				salesTrendChart.showLoading({
					text : "图表数据正在努力加载..."
				});
				//加载图表  
				var salesTrendOption = {
					title : {
						text : '销量走势'
					},
					tooltip : {
						trigger : 'axis'//item  axis  
					},
					legend : {
						data : [ '销售量' ]
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
					calculable : true,
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '10/16', '10/17', '10/18', '10/19', '10/20',
								'10/21', '10/22' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value}'
						},
						splitNumber : 10
					} ],
					series : [ {
						name : '销售量',
						type : 'line',
						data : [ 89, 91, 91, 89, 92, 91, 90 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						}
					} ]
				};
				var productRecommendChart = ec.init(document
						.getElementById('product-recommend'));
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
							value : 100,
							itemStyle : {
								normal : {
									color : 'black'
								}
							}
						}, {
							name : "Innisfree洁面奶",
							value : 61,
							itemStyle : createRandomItemStyle()
						}, {
							name : "花印美白精华",
							value : 4386,
							itemStyle : createRandomItemStyle()
						}, {
							name : "保水面膜",
							value : 4055,
							itemStyle : createRandomItemStyle()
						}, {
							name : "气垫bb",
							value : 2467,
							itemStyle : createRandomItemStyle()
						}, {
							name : "补水保湿霜",
							value : 2244,
							itemStyle : createRandomItemStyle()
						}, {
							name : "去角质膏",
							value : 1898,
							itemStyle : createRandomItemStyle()
						}, {
							name : "一叶子面膜",
							value : 1484,
							itemStyle : createRandomItemStyle()
						}, {
							name : "身体乳",
							value : 1112,
							itemStyle : createRandomItemStyle()
						}, {
							name : "护发素",
							value : 965,
							itemStyle : createRandomItemStyle()
						} ]
					} ]
				};
				var blandRecommendChart = ec.init(document
						.getElementById('bland-recommend'));
				blandRecommendChart.showLoading({
					text : "图表数据正在努力加载..."
				});
				var blandRecommendOption = {
					title : {
						text : '品牌推荐'
					},
					tooltip : {
						show : true
					},
					series : [ {
						name : '品牌推荐',
						type : 'wordCloud',
						size : [ '80%', '80%' ],
						textRotation : [ 0, 45, 90, -45 ],
						textPadding : 0,
						autoSize : {
							enable : true,
							minSize : 14
						},
						data : [ {
							name : "雅诗兰黛",
							value : 100,
							itemStyle : {
								normal : {
									color : 'black'
								}
							}
						}, {
							name : "Innisfree",
							value : 61,
							itemStyle : createRandomItemStyle()
						}, {
							name : "花印",
							value : 4386,
							itemStyle : createRandomItemStyle()
						}, {
							name : "兰蔻",
							value : 4055,
							itemStyle : createRandomItemStyle()
						}, {
							name : "美宝莲",
							value : 2467,
							itemStyle : createRandomItemStyle()
						}, {
							name : "资生堂",
							value : 2244,
							itemStyle : createRandomItemStyle()
						}, {
							name : "比度克",
							value : 1898,
							itemStyle : createRandomItemStyle()
						}, {
							name : "一叶子",
							value : 1484,
							itemStyle : createRandomItemStyle()
						}, {
							name : "玛丽黛佳",
							value : 1112,
							itemStyle : createRandomItemStyle()
						}, {
							name : "护发素",
							value : 965,
							itemStyle : createRandomItemStyle()
						}]
					} ]
				};
				var url='${pageContext.request.contextPath}/jsonTest.action?typeId=<%=request.getAttribute("typeId")%>';
					//通过Ajax获取数据 
		            $.ajax({  
		                type : "post",  
		                async : false, //同步执行  
		                url : url,    
		                dataType : "json", //返回数据形式为json  
		                success : function(result) {  
		                    if (result) {  
		                    	priceDistributeOption.xAxis[0].data = result.priceInterval;  
		                    	priceDistributeOption.series[0].data = result.productCount;
		                    	priceTrendOption.xAxis[0].data = result.priceTime;  
		                    	priceTrendOption.series[0].data = result.priceData;
		                    	salesTrendOption.xAxis[0].data = result.salesTime;  
		                    	salesTrendOption.series[0].data = result.productSales;
		                    	
		                    	//alert(result.productName.length);
		                    	
		                    	for(var i=0;i<result.productName.length;i++){
		                    		productRecommendOption.series[0].data[i].name=result.productName[i].substring(0,10);
			                    	productRecommendOption.series[0].data[i].value=result.productSales[i];
		                    	}
		                    	
		                    	for(var i=0;i<result.brandName.length;i++){
		                    		blandRecommendOption.series[0].data[i].name=result.brandName[i];
			                    	blandRecommendOption.series[0].data[i].value=result.brandSales[i];
		                    	}
		                    	
		                    	 
		                    	priceDistributeChart.hideLoading();  
		                    	priceDistributeChart.setOption(priceDistributeOption); 
		                    	priceTrendChart.hideLoading();  
		                    	priceTrendChart.setOption(priceTrendOption);
		                    	salesTrendChart.hideLoading();  
		                    	salesTrendChart.setOption(salesTrendOption);
		                    	productRecommendChart.hideLoading();  
		                    	productRecommendChart.setOption(productRecommendOption);
		                    	blandRecommendChart.hideLoading();  
		                    	blandRecommendChart.setOption(blandRecommendOption);
		                    }  
		                },  
		                error : function(errorMsg) {  
		                    alert("不好意思，大爷，图表请求数据失败啦!");  
		                    priceDistributeChart.hideLoading();
		                    priceTrendChart.hideLoading();
		                    salesTrendChart.hideLoading();
		                    productRecommendChart.hideLoading();
		                    blandRecommendChart.hideLoading();
		                }  
		            });
			});
		</script>
		
		<div id="content" >
			<div id="tabs" class="tabs">
				<a href="javascript:void(0);" class="selected"
					onclick="tabchange(this)" id="tanalysis">分析结果</a> <a
					href="javascript:void(0);" onclick="tabchange(this)"
					id="tproductlist">商品列表</a>
			</div>

			<div id="tab-analysis" class="tab-content">
				<hr style="border: 1px dotted #ccc" />
				<span style="font-size: 16px;">&nbsp;&nbsp;&nbsp;&nbsp;产品总数：<span
					style="color: #e83d02;"><s:property value="productCount"/></span></span> <br> <span
					style="font-size: 16px;">&nbsp;&nbsp;&nbsp;&nbsp;平均价格：<span
					style="color: #e83d02;"><s:property value="averagePrice"/></span></span>
				<hr style="border: 1px dotted #ccc" />
				<div class="category-info" id="price-distribute"
					style="height: 400px; width: 735px;"></div>
				<div class="category-info" id="price-trend"
					style="height: 400px; width: 735px;"></div>
				<div class="category-info" id="sales-trend"
					style="height: 400px; width: 735px;"></div>
				<div class="category-info" id="product-recommend"
					style="height: 400px; width: 735px;"></div>
				<div class="category-info" id="bland-recommend"
					style="height: 400px; width: 735px;"></div>
				<div class="clearfix"></div>
			</div>
			<div id="tab-productlist" class="tab-content">
			  <s:iterator value="productList" id="product">
				<div class="product-list" id="product-list1">
					<div class="struct">
						<div class="line">
							<a href="<s:property value="goods_url" />" class="image-link">
								<div class="image"> 
									<img style="width:95%; margin-bottom:20px" src="<s:property value="goods_picture" />" title="Innisfree" alt="Innisfree" />
								</div>
								
							</a>
							<div class="right">
								<div class="name" id="plistname">
								<s:a action="product.action?goodsCode=%{goods_code}"><s:property value="goods_name" /></s:a>
								</div>
								<div class="price" id="plistprice">
									价格：<s:property value="price" />元
								</div>
								<div class="description">
									<span>品牌名称：</span>
									<s:property value="brands.goods_brand_name" />								
									<br>
									<span>来源网站：</span>
									<s:property value="site.sites_chinese_name" />
							    </div>
								
							</div>	
							<div class="cart combo" id="combo11">
									<s:a action="product.action?goodsCode=%{goods_code}" title="Watch the Anaylysis">
										<span class="icon icon-compare">&nbsp;</span>
									</s:a>
									<a href="<s:property value="goods_url" />" title="Go to Purchase"> <span
										class="icon icon-basket">&nbsp;</span></a> <a
										title="Add to Compare"> <span class="icon icon-wish">&nbsp;</span></a>
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
	</div>
	</div>

	<!-- footer part -->
	<s:action name="footer" namespace="/" executeResult="true"
		ignoreContextParams="true"></s:action>
	<!-- footer part finished -->
</body>
</html>