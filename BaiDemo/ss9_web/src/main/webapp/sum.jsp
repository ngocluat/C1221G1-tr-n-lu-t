<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 4/12/2022
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello C12
<%
    double number1 = Double.parseDouble(request.getParameter("number1"));
    double number2 = Double.parseDouble(request.getParameter("number2"));
    double result = number1 + number2;
%>
<h2 style="color: red"><%=result%>
</h2>
</body>
</html>
