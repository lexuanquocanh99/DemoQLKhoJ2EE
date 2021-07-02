<%--
  Created by IntelliJ IDEA.
  User: AaronLX
  Date: 7/2/2021
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <li><a href="<%=request.getContextPath()%>/listphieu" class="nav-link">Phieu</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
                <c:if test="${phieu == null}">
                <form action="insertphieu" method="post">
                    </c:if>
                    <caption>
                        <h2>
                            <c:if test="${phieu == null}">
                                Add New Phieu
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${phieu != null}">
                        <input type="hidden" name="id" value="<c:out value='${phieu.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Loai Phieu</label>
                        <select name="loaiphieu">
                            <option value="nhap" <c:if test="${phieu.loaiphieu == 'nhap'}"><c:out value='selected' /></c:if>>Nhap</option>
                            <option value="xuat" <c:if test="${brand.loaiphieu == 'xuat'}"><c:out value='selected' /></c:if>>Xuat</option>
                        </select>
                    </fieldset>

                    <fieldset class="form-group">
                        <label>ID Mat Hang</label> <input type="number" value="<c:out value='${phieu.idmathang}' />" class="form-control" name="idmathang" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>ID Kho</label> <input type="number" value="<c:out value='${phieu.idkho}' />" class="form-control" name="idkho" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>So luong</label> <input type="number" value="<c:out value='${phieu.soluong}' />" class="form-control" name="soluong" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Ngay</label> <input type="date" value="<c:out value='${phieu.ngay}' />" class="form-control" name="ngay" required="required">
                    </fieldset>
                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>
