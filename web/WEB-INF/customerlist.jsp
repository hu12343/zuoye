<%@ page import="cn.edu.xaut.DAO.customerDAOimpl" %>
<%@ page import="cn.edu.xaut.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=GB2312"
		 pageEncoding="GB2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>¹Ë¿Ílist</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2009/11/20 <br/>
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>Welcome!</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>Name</td>
						<td>Age</td>
						<td>Sex</td>
						<td>City</td>
						<td>Operations</td>
					</tr>
					<s:iterator var="customer" value="customers" status="st">
					<tr class="row1">
						<td><s:property value="id"/></td>
						<td><s:property value="name"/></td>
						<td><s:property value="age"/></td>
						<td><s:property value="sex"/></td>
						<td><s:property value="city"/></td>
						<td><a href="customerlist.html">delete customer</a>&nbsp;
							<a href="updatecustomer.html">update customer</a></td>
					</tr>
					</s:iterator>
				</table>
				<p>
					<input type="button" class="button" value="Add customer"
						onclick="location='toAdd.action'" />
				</p>
			</div>
			 <div align="right">
			<s:if test="page==1">
			<a href="customer.action">previous page</a>
			 </s:if>
			 <s:if test="page!=1">
			 <a href="customer.action?page=${page-1}">previous page</a>
			 </s:if>
			<s:iterator var="i" begin="1" end="totalPage">
			 <s:if test="page==#i">
			 ${i}
			 </s:if>
			 <s:if test="page!=#i">
			 <a href="customer.action?page=${i }">${i }</a>
			</s:if>
			</s:iterator>
			 <s:if test="page==totalPage">
				 <a href="customer.action">next page</a>
			 </s:if>
			<s:if test="page!=totalPage">
			 <a href="customer.action?page=${page+1}">next page</a>
			 </s:if>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>

