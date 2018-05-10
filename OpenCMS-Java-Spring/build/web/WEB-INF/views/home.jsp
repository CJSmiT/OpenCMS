<%-- 
    Document   : home
    Created on : 24.03.2017, 11:40:45
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        
        <jsp:include page="menu.jsp" />
        
            <div style="margin:0 auto; max-width: 900px; width:100%">
                <div>
                    <c:forEach var="material" items="${materialsCat1}">
                        <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                            <h3 style="color: blue">${material.getTitle()}</h3>
                        </a>
                            <c:forEach var="textBody" items="${textUtil.getSubText(material.getTextBody())}">
                                <p>${textBody}</p>
                            </c:forEach>
                    </c:forEach>
                </div>
                    <hr>
                <div>
                    <c:forEach var="material" items="${materialsCat2}">
                        <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                            <h3 style="color: blue">${material.getTitle()}</h3>
                        </a>
                            <c:forEach var="textBody" items="${textUtil.getSubText(material.getTextBody())}">
                                <p>${textBody}</p>
                            </c:forEach>
                    </c:forEach>
                </div>
                    <hr>
                <div>
                    <c:forEach var="material" items="${materialsCat3}">
                       <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                            <h3 style="color: blue">${material.getTitle()}</h3>
                        </a>
                            <c:forEach var="textBody" items="${textUtil.getSubText(material.getTextBody())}">
                                <p>${textBody}</p>
                            </c:forEach>
                     </c:forEach>
                </div>
            </div>
    </body>
</html>
