<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="refresh" content="5" >
</head>
<body>
Show Score
<br>
<br>
<table>
    <c:forEach items="${users}" var="users">
        <tr>
            <td>${users.getTeamA()}</td>
            <td>${users.getTeamB()}</td>
            <td>${users.getScoreA()}</td>
            <td>${users.getScoreB()}</td>
            
            <br>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>