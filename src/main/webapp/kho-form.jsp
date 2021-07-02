<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
  <title>Kho Management Application</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
    <div>
      <a href="#" class="navbar-brand">Kho Management App</a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/listbrand" class="nav-link">Brands</a></li>
      <li><a href="<%=request.getContextPath()%>/listkho" class="nav-link">Kho</a></li>
    </ul>
  </nav>
</header>
<br>
<div class="container col-md-5">
  <div class="card">
    <div class="card-body">
      <c:if test="${kho != null}">
      <form action="updatekho" method="post">
        </c:if>
        <c:if test="${kho == null}">
        <form action="insertkho" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${kho != null}">
                Edit Kho
              </c:if>
              <c:if test="${kho == null}">
                Add New Kho
              </c:if>
            </h2>
          </caption>

          <c:if test="${kho != null}">
            <input type="hidden" name="id" value="<c:out value='${kho.id}' />" />
          </c:if>

          <fieldset class="form-group">
            <label>Ten Kho</label> <input type="text" value="<c:out value='${kho.ten}' />" class="form-control" name="tenkho" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>Dia Diem</label> <input type="text" value="<c:out value='${kho.diadiem}' />" class="form-control" name="diadiem" required="required">
          </fieldset>

          <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
  </div>
</div>
</body>

</html>
