<%-- 
    Document   : user
    Created on : 27 déc. 2020, 19:54:32
    Author     : ISO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Welcome</title>
</head>
<body>
<h1><c:out value='${users}' /></h1>
<table>
 <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.studentId}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.password}"/></td>
        </tr>
 </c:forEach>
</table>
</body>
</html>
