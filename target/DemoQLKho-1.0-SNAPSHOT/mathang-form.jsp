<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>MH Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
        <div>
            <a href="#" class="navbar-brand">MH Management App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/listbrand" class="nav-link">Brands</a></li>
            <li><a href="<%=request.getContextPath()%>/listkho" class="nav-link">Kho</a></li>
            <li><a href="<%=request.getContextPath()%>/listmathang" class="nav-link">MatHang</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${mathang != null}">
            <form action="updatemathang" method="post">
                </c:if>
                <c:if test="${mathang == null}">
                <form action="insertmathang" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${mathang != null}">
                                Edit Mat Hang
                            </c:if>
                            <c:if test="${mathang == null}">
                                Add New Mat Hang
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${mathang != null}">
                        <input type="hidden" name="id" value="<c:out value='${mathang.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Ten</label> <input type="text" value="<c:out value='${mathang.ten}' />" class="form-control" name="tenMH" required="required">
                    </fieldset>

                        <fieldset class="form-group">
                            <label>Mo Ta</label> <input type="text" value="<c:out value='${mathang.mota}' />" class="form-control" name="moTa" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Chat Lieu</label> <input type="text" value="<c:out value='${mathang.chatlieu}' />" class="form-control" name="chatLieu" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Noi San Xuat</label> <input type="text" value="<c:out value='${mathang.noisx}' />" class="form-control" name="noiSX" required="required">
                        </fieldset>

                    <fieldset class="form-group">
                        <label>Ngay San Xuat</label> <input type="date" value="<c:out value='${mathang.ngaysx}' />" class="form-control" name="ngaySX" required="required">
                    </fieldset>

                        <fieldset class="form-group">
                            <label>ID Mat Hang</label> <input type="text" value="<c:out value='${mathang.idnhanhieu}' />" class="form-control" name="idNhanHieu" required="required">
                        </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>