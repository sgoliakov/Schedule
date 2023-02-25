<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Plan</title>
</head>
<body>
<form method="post" action="controller?action=main">
    <input type="submit" value="Go to main"/>
</form>
<c:if test="${not empty requestScope.notAdd}">
    <p style="color: red">shift not added</p>
</c:if>
<c:if test="${not empty requestScope.Add}">
    <p style="color: blue">shift added</p>
</c:if>
<c:forEach items="${requestScope.planSchedule}" var="shift">
    <form method="post" action="controller?action=add_new_shift">
        <p>${shift.day} : ${shift.shift}</p>
        <input type="hidden" name="id" value="${shift.id}"/>
        <input type="submit" value="Add into free shift"/>
    </form>
</c:forEach>
<form method="post" action="controller?action=main">
    <input type="submit" value="Go to main"/>
</form>
</body>
</html>
