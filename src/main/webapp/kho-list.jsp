<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta charset="ISO-8859-1">
  <title>Quan Ly kho</title>
</head>
<body>
<div style="margin-left: 200px">
  <h1>QUAN LY KHO</h1>
  <h2>
    <a href="newkho">Them moi</a>
  </h2>
</div>
<table border="1" cellpadding="5">
  <tr>
    <th> ID </th>
    <th>  Ten Kho  </th>
    <th>  Dia Diem   </th>
  </tr>
  <c:forEach var="kho" items="${listKho}">
    <tr>
      <td> <c:out value="${kho.id }"></c:out> </td>
      <td> <c:out value="${kho.ten }"></c:out> </td>
      <td> <c:out value="${kho.diadiem }"></c:out> </td>
      <td>
        <a href="editkho?id=<c:out value="${kho.id }"/>">Edit</a>
        <a href="deletekho?id=<c:out value="${kho.id }"/>">Delete</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
