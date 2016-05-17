<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<%
	String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/style.css" />
<title></title>
</head>

<body>
<!-- header part -->
<s:action name="header" namespace="/" executeResult="true" ignoreContextParams="true"></s:action>
<!-- header part finished -->

<!-- content part -->
	<div id="wrapper">
		<div class="slider-wrapper theme-orman">
			<div class="ribbon"></div>
			<div id="slider" class="nivoSlider"
				style="border: 1px solid categories.jsp444; box-shadow: 0 0 5px 0 categories.jsp080808;">
				<s:a action="search"><img src="<%=basePath%>/images/banner.jpg" alt=""
					title="Data visualization --- Find the beauty of data applications" /></s:a> <s:a href="searchresult.jsp"><img
					src="<%=basePath%>/images/banner2.jpg" alt=""
					title="Data visualization --- Find the beauty of data applications" /></s:a>
			</div>
			<br>
			<div class="controlNav_box"></div>
		</div>
	</div>
	
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery.nivo.slider.pack.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('#slider').nivoSlider();
		});
	</script>
	<div class="container">
		<div class="text_box_left">Featured</div>
		<div class="box-product">
		
			<div>	
				<div class="showhim">
					<div class="image">
						<s:a action="product"><img src="<%=basePath%>/images/product_holder.jpg"
							alt="iMac" />
							<div class="showme">
								<div class="description_featured" style="min-height: 110px;">
									<p>Just when you thought iMac had everything, now there is
										even more. More powerful Intel Core 2 Duo processors. And more
										memory standard. ...</p>
								</div>
							</div> </s:a>
						<div class="name">
							<a href="#">DataChart</a>
						</div>
						<div class="priced">
							<ul>
								<li>Data</li>
								<li><a href="#">气泡图</a></li>
							</ul>
						</div>
						<div style="margin-top: 24px;"></div>
					</div>
					<div class="showme"></div>
				</div>
			</div>
			
			<div>
				<div class="showhim">
					<div class="image">
						<s:a action="product"><img src="<%=basePath%>/images/product_holder1.jpg"
							alt="iPhone" />
							<div class="showme">
								<div class="description_featured" style="min-height: 110px;">
									<p>iPhone is a revolutionary new mobile phone that allows
										you to make a call by simply tapping a name or number in your
										address book, a favo...</p>
								</div>
							</div> </s:a>
						<div class="name">
							<a href="#">DataChart</a>
						</div>
						<div class="priced">
							<ul>
								<li>Data</li>
								<li><a href="product.jsp">词云图</a></li>
							</ul>
						</div>
						<div style="margin-top: 24px;"></div>
					</div>
				</div>
			</div>
			
			<div>
				<div class="showhim">
					<div class="image">
						<a href="#"><img src="<%=basePath%>/images/product_holder2.jpg"
							alt="iPod Classic" />
							<div class="showme">
								<div class="description_featured" style="min-height: 110px;">
									<p>More room to move.With 80GB or 160GB of storage and up
										to 40 hours of battery life, the new iPod classic lets you
										enjoy...</p>
								</div>
							</div> </a>
						<div class="name">
							<a href="#">DataChart</a>
						</div>
						<div class="priced">
							<ul>
								<li>Data</li>
								<li><a href="#">柱形图</a></li>
							</ul>
						</div>
						<div style="margin-top: 24px;"></div>
					</div>
					<div class="showme"></div>
				</div>
			</div>
			
			<div>
				<div class="showhim">
					<div class="image">
						<a href="#"><img src="<%=basePath%>/images/product_holder3.jpg"
							alt="iPod Nano" />
							<div class="showme">
								<div class="description_featured" style="min-height: 110px;">
									<p>Video in your pocket. Its the small iPod with one very
										big idea: video. The worlds most popular music player now lets
										you enjoy...</p>
								</div>
							</div> </a>
						<div class="name">
							<a href="#">DataChart</a>
						</div>
						<div class="priced">
							<ul>
								<li>Data</li>
								<li><a href="#">饼状图</a></li>
							</ul>
						</div>
						<div style="margin-top: 24px;"></div>
					</div>
					<div class="showme"></div>
				</div>
			</div>
			
		</div>
	</div>
	<br>
<!-- content part finished -->

<!-- footer part -->
<s:action name="footer" namespace="/" executeResult="true" ignoreContextParams="true"></s:action>
<!-- footer part finished -->
</body>
</html>
