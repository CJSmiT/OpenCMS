<%-- 
    Document   : materialView
    Created on : 27.04.2018, 18:15:51
    Author     : smit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${material.getTitle()}</title>
        <jsp:include page="headLinks.jsp" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div style="margin:0 auto;max-width: 1000px; width: 100%">
            <a href="${pageContext.request.contextPath}/material_manager?alias=${material.getAlias()}">
                <button type="button" class="btn btn-primary">Manager material</button>           
            </a>
            <c:choose>
                <c:when test="${material.isIsPublic() == false}">
                    <h1 style="color: red">${material.getTitle()}</h1>
                </c:when> 
                <c:otherwise>
                    <h1 style="color: green">${material.getTitle()}</h1>
                </c:otherwise>
            </c:choose>                
            <c:forEach var="textBody" items="${textUtil.getParagraph(material.getTextBody())}">
                    <p>${textBody}</p>
            </c:forEach>
        </div>
    </body>
</html>