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
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <c:forEach var="categori" items="${categories}">
            <p><a href="show_materials?alias=${categori.getAlias()}">${categori.getTitle()}</a></p>
        </c:forEach>
    </body>
</html>
