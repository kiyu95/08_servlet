<%--
  Created by IntelliJ IDEA.
  User: wlsals602
  Date: 2023-11-24
  Time: 오후 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1> 직원 목록 전체 조회 </h1>
    <table>
        <tr>
            <th>사원번호</th>
            <th>직원명</th>
            <th>이메일</th>
            <th>전화번호</th>
        </tr>
        <c:forEach items="${requestScope.emplist}" var="emp">
            <tr>
                <td>${emp.empId}</td>
                <td>${emp.empName}</td>
                <td>${emp.email}</td>
                <td>${emp.phone}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
