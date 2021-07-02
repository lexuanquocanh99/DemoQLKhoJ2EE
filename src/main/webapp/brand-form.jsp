<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
  <title>Brand Management Application</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
    <div>
      <a href="#" class="navbar-brand">Brand Management App</a>
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
      <c:if test="${brand != null}">
      <form action="updatebrand" method="post">
        </c:if>
        <c:if test="${brand == null}">
        <form action="insertbrand" method="post">
          </c:if>

          <caption>
            <h2>
              <c:if test="${brand != null}">
                Edit Brand
              </c:if>
              <c:if test="${brand == null}">
                Add New Brand
              </c:if>
            </h2>
          </caption>

          <c:if test="${brand != null}">
            <input type="hidden" name="id" value="<c:out value='${brand.id}' />" />
          </c:if>

          <fieldset class="form-group">
            <label>Name</label> <input type="text" value="<c:out value='${brand.ten}' />" class="form-control" name="name" required="required">
          </fieldset>

          <fieldset class="form-group">
            <label>Description</label> <input type="text" value="<c:out value='${brand.mota}' />" class="form-control" name="description">
          </fieldset>

          <button type="submit" class="btn btn-success">Save</button>
        </form>
    </div>
  </div>
</div>
</body>

</html>
