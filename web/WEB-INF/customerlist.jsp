<%@ page import="cn.edu.xaut.DAO.customerDAO" %>
<%@ page import="cn.edu.xaut.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=GB2312"
		 pageEncoding="GB2312"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>emplist</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						2009/11/20 <br />
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
					<%
						customerDAO customerDAO=new customerDAO();
						List<Customer> list=customerDAO.select();
							out.print("ID  ");
							out.print("NAME ");
							out.print("AGE ");
							out.print("SEX ");
							out.print("CITY  <br>");
						for(Customer c : list)
						{
							out.print(c.getId()+"  ");
							out.print(c.getName()+" ");
							out.print(c.getAge()+" ");
							out.print(c.getSex()+" ");
							out.print(c.getCity()+"  <br>");
						}
					%>
				<p>
					<input type="button" class="button" value="Add Employee"
						onclick="location='toAdd.action'" />
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>

