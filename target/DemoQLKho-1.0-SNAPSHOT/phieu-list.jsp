<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Quan Ly Nhap Xuat</title>
</head>
<body>
<div style="margin-left: 200px">
  <h1>QUAN LY PHIEU</h1>
  <h2>
    <a href="newphieu">Them Phieu</a>
  </h2>
</div>
<table>
  <tr>
    <th>ID</th>
    <th>Loai Phieu</th>
    <th>ID Mat Hang</th>
    <th>ID Kho</th>
    <th>So Luong</th>
    <th>Ngay</th>
  </tr>
  <c:forEach var="phieu" items="${listPhieu}">
    <tr>
      <td> <c:out value="${phieu.id }"></c:out> </td>
      <td> <c:out value="${phieu.loaiphieu }"></c:out> </td>
      <td> <c:out value="${phieu.idmathang}"></c:out> </td>
      <td> <c:out value="${phieu.idkho}"></c:out> </td>
      <td> <c:out value="${phieu.soluong}"></c:out> </td>
      <td> <c:out value="${phieu.ngay}"></c:out> </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
