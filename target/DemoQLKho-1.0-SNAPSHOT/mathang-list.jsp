<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    td {
      padding: 10px;
    }

    thead td {
      text-align: center;
    }

    .btn {
      text-decoration: none;
      background-color: rgb(16, 73, 14);
      color: #FFF;
      padding-top: 10px;
      padding-right: 30px;
      padding-bottom: 10px;
      border-radius: 10px;
      padding-left: 30px;
      margin: 10px;
    }

    .delete {
      background-color: #5A0002;
    }

    .edit {
      background-color: #D7CF07;
    }
    .trangThai{
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .edit:hover {
      background-color: #A40606;
      color: #FFF;
    }

    .btn:hover {
      background-color: #A40606;
      color: #FFF;
    }
  </style>
  <title>Document</title>
</head>

<body style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
<div style="margin: 40px;">
  <h1>Quản MH</h1>
  <h4 style="color: #555555;">Danh MH</h4>
  <a href="newmathang">Add</a>
  <table>
    <thead>
    <tr style="padding: 10px; font-weight: bold;">
      <td>ID</td>
      <td>Ten MH</td>
      <td>Mo ta</td>
      <td>Chat Lieu</td>
      <td>Noi San Xuat</td>
      <td>Ngay San Xuat</td>
      <td>ID Mat Hang</td>
      <td>Hanh Dong</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="mh" items="${mathang}" >
      <tr>
        <td><c:out value="${mh.id}"></c:out> </td>
        <td><c:out value="${mh.ten}"></c:out> </td>
        <td><c:out value="${mh.mota}"></c:out> </td>
        <td><c:out value="${mh.chatlieu}"></c:out> </td>
        <td><c:out value="${mh.noisx}"></c:out> </td>
        <td><c:out value="${mh.ngaysx}"></c:out> </td>
        <td><c:out value="${mh.idnhanhieu}"></c:out> </td>
        <td class="trangThai">
          <a class="btn edit" href="editmathang?id=<c:out value="${mh.id}"/>">Edit</a>
          <a class="btn delete" href="deletemathang?id=<c:out value="${mh.id}"/>">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>

</html>
