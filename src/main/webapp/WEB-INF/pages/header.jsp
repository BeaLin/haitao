<%@page import="cn.edu.zju.cst.ideas.domain.Type"  %>
<%@page import="java.util.List"  %>
<%
	String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- search box -->
<div style="width: 80%; margin: 0 auto;">
	<s:form action="search" id="search" method="search">
		<input class="input-text" type="text" name="searchContext"
			value="Search" onclick="this.value = '';"
			onkeydown="this.style.color = 'categories.jsp888';" />
		<input type="submit" value="" class="button-search" />
	</s:form>
</div>
<!-- logo part -->
<div class="header">
	<div class="logo_img">
		<s:a action="index">
			<img alt="Site Home"
				src="<%=basePath %>/images/logo.png">
		</s:a>
	</div>
</div>
<!-- menu part -->
<div id="menu">
	<ul>
<!--<s:iterator value="categoryDetailList" id="categoryCol">
		<li><a href="#"><s:property value="key"/></a>
			<div>
				<ul>
					<s:iterator value="#categoryCol.value" id="typeRow">
						<li>
							<s:iterator value="typeRow">
								<s:a action="category.action?typeId=%{key}" ><s:property value="value"/></s:a>
							</s:iterator>
						</li>
					</s:iterator>
				</ul>
			</div>
		</li>
		</s:iterator>	-->	
		<s:iterator value="typeList" var="type">
		<li><s:a action="category.action?typeId=%{type_id}"><s:property value="type_name"/></s:a>
		</li>
		</s:iterator>
	</ul>
</div>