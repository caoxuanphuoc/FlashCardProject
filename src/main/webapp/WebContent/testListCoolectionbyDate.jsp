<%@page import="Bean.CollectionCard"%>
<%@page import="Bean.Dto.CollectionByDateDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Bo.CollectionBo"%>
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
<%-- <%CollectionBo  colecBo1 = new CollectionBo(); 
ArrayList<CollectionCard> a = colecBo1.GetAll() ;
	for(CollectionCard xx: a){
%>
<h1> <%=xx.getCreateAt() %></h1>
<%} %> --%>



<% CollectionBo  colecBo = new CollectionBo();

	ArrayList<CollectionByDateDto> Dsbydate = colecBo.GetCollectionByDate();
	for( CollectionByDateDto Paren: Dsbydate){
%>
<span><%= Paren.getCreatedAt()%></span>
<%		for( CollectionCard child : Paren.getListCollection()){
%>
<h2> <%=child.getCollectionName() %></h2>
<%}} %> 
</body>
</html>