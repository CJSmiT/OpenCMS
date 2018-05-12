<%-- 
    Document   : categories
    Created on : 27.04.2018, 17:24:47
    Author     : smit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories</title>
        <jsp:include page="headLinks.jsp" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <c:forEach var="category" items="${categories}">
            <p><a href="category_materials?catId=${category.getId()}">${category.getTitle()}</a></p>
        </c:forEach>
    </body>
</html>
