<%-- 
    Document   : all_materials
    Created on : 29.04.2018, 11:52:07
    Author     : alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All materials</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <div style="margin: 0 auto; max-width: 1000px; width: 100%">
            <c:forEach var="material" items="${Allmaterials}">
                <a href="show_material?alias=${material.getAlias()}">
                            <h3 style="color: blue">${material.getTitle()}</h3>
                </a>
                <p>${material.getTextBody()}</p>
            </c:forEach>
        </div>
    </body>
</html>
