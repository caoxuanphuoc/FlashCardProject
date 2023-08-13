<%@page import="Bo.CardBo"%>
<%@page import="Bean.Card"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>CHECK</h1>
<%-- <%
	//check dao

	//check bo
	CardBo a = new CardBo();
	//a.Delete((long)4);
	//Card c = new Card((long)4, (long) 6, "phuoc", "BackText", "ImgFront", "ImgBack", false);
	//int k = a.Update(c);
	//for( Card x : a.GetAll((long)1)){
%>
	<h1> <%=x.toString() %></h1>
<%//} %> --%>
<%
	Card c = new Card((long)4, (long) 7, null, "phuoc", "phuoc" , null ,null);
	String url = c.RequestURL();
%>
<h1><%=url %></h1>
</body>
</html>