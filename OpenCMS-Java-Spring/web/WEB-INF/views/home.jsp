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
        <jsp:include page="headLinks.jsp" />
    </head>
    <body>
        
        <jsp:include page="menu.jsp" />
        
        <div class="panel panel-default" style="margin:0 auto; max-width: 900px; width:100%">
            <div class="panel-body">
                
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Materials by cat 1
                    </div>
                    <div class="panel-body">
                        <c:forEach var="material" items="${materialsCat1}">
                            <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                                <h3 style="color: blue">${material.getTitle()}</h3>
                            </a>
                            <c:forEach var="textBody" items="${textUtil.getSubText200(material.getTextBody())}">
                                <p>${textBody}</p>
                            </c:forEach>
                                <hr>
                        </c:forEach>
                    </div>
                </div>
                
                <div class="panel panel-info">
                    <div class="panel-heading">
                        Materials by cat 2
                    </div>
                    <div class="panel-body">
                        <c:forEach var="material" items="${materialsCat2}">
                            <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                                <h3 style="color: blue">${material.getTitle()}</h3>
                            </a>
                            <c:forEach var="textBody" items="${textUtil.getSubText200(material.getTextBody())}">
                                <p>${textBody}</p>
                            </c:forEach>
                                <hr>
                        </c:forEach>
                    </div>
                </div>
                

            </div>
        </div>
                
    </body>
</html>
