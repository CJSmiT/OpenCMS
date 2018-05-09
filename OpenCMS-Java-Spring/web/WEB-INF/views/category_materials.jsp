<%-- 
    Document   : category_materials
    Created on : 09.05.2018, 22:20:28
    Author     : alex
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category materials</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <div style="margin: 0 auto; max-width: 1000px; width: 100%">
            <c:forEach var="material" items="${category_materials}">
                <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                    <c:choose>
                        <c:when test="${material.isIsPublic() == false}">
                            <h3 style="color: red">${material.getTitle()}</h3>
                        </c:when> 
                        <c:when test="${material.isIsPublic() == true}">
                            <h3 style="color: green">${material.getTitle()}</h3>
                        </c:when>   
                        <c:otherwise>
                            Что-то пошло не так ....
                            <br />
                        </c:otherwise>
                    </c:choose>          
                </a>
                <c:forEach var="textBody" items="${textUtil.getSubText(material.getTextBody())}">
                    <p>${textBody}</p>
                </c:forEach>
            </c:forEach>
        </div>
    </body>
</html>
