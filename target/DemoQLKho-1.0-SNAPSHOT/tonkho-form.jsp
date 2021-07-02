<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>TK Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="#" class="navbar-brand">TK Management App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listbrand" class="nav-link">Brands</a></li>
            <li><a href="<%=request.getContextPath()%>/listkho" class="nav-link">Kho</a></li>
            <li><a href="<%=request.getContextPath()%>/listmathang" class="nav-link">Mat Hang</a></li>
            <li><a href="<%=request.getContextPath()%>/listtonkho" class="nav-link">Ton Kho</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${tk != null}">
            <form action="updatetonkho" method="post">
                </c:if>
                <c:if test="${tk == null}">
                <form action="inserttonkho" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${tk != null}">
                                Edit Ton Kho
                            </c:if>
                            <c:if test="${tk == null}">
                                Add New Ton Kho
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${tk != null}">
                        <input type="hidden" name="id" value="<c:out value='${tk.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>ID Cua Hang</label> <input type="text" value="<c:out value='${tk.idkho}' />" class="form-control" name="idCH" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>ID Mat Hang</label> <input type="text" value="<c:out value='${tk.idmathang}' />" class="form-control" name="idMH" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>So Luong</label> <input type="text" value="<c:out value='${tk.soluong}' />" class="form-control" name="sl" required="required">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>
