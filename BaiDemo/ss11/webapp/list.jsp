<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/13/2022
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<button class="btn btn-primary" style="color: white"><a href="/student?action=create">Thêm mới</a></button>
<table class="table table-striped">
    <tr class="row">
        <th class="col-1">STT</th>
        <th class="col-2">Mã học sinh</th>
        <th class="col-2">Tên</th>
        <th class="col-3">Ngày sinh</th>
        <th class="col-2">Giới tính</th>
        <th class="col-2">Điểm</th>
    </tr>
    <c:forEach var="student" items="${students}" varStatus="haitt">
        <tr class="row">
            <td class="col-1">${haitt.count}</td>
            <td class="col-2">${student.id}</td>
            <td class="col-2">${student.name}</td>
            <td class="col-3">${student.dateOfBirth}</td>
<%--            <td>${student.gender}</td>--%>
            <td class="col-2">
                <c:if test="${student.gender == 0}">
                    Nữ
                </c:if>
                <c:if test="${student.gender == 1}">
                    Nam
                </c:if>
            </td>
<%--            <td class="col-2">${student.grade}</td>--%>
            <td>
                <c:choose>
                    <c:when test="${student.grade >9 && student.grade <10}">Giỏi</c:when>
                    <c:when test="${student.grade >7}">Khá</c:when>
                    <c:when test="${student.grade >5}">Trung bình</c:when>
                    <c:when test="${student.grade <=5}">Yếu</c:when>
                    <c:otherwise>Ngoại lệ</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
</body>
</html>
