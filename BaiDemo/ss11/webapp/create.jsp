<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/14/2022
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <label>Tên học sinh:</label>
    <input type="text" name="name"><br>
    <p style="color:red;">${error.get("name")}</p>
    <label>Ngày sinh:</label>
    <input type="date" name="dateOfBirth"><br>
    <label>Điểm:</label>
    <input type="number" name="grade"><br>
    <label>Giới tính:</label>
    <select name="gender">
        <option value="1">Nam</option>
        <option value="0">Nữ</option>
        <option value="-1">Khác</option>
    </select>
    <button type="submit">Thêm mới</button>
</form>
</body>
</html>
