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
        <jsp:include page="headLinks.jsp" />
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
                
        
        <div style="margin: 0 auto; max-width: 1000px; width: 100%">
            <div class="panel panel-info">
                    <div class="panel-heading">
                        All materials
                    </div>
                    <div class="panel-body">
                       <c:forEach var="material" items="${all_materials}">
                        <div class="panel-heading">
                            <a href="${pageContext.request.contextPath}/show_material?alias=${material.getAlias()}">
                                <c:choose>
                                    <c:when test="${material.isIsPublic() == false}">
                                        <h3 style="color: red">${material.getTitle()}</h3>
                                    </c:when> 
                                    <c:when test="${material.isIsPublic() == true}">
                                        <h3 style="color: green">${material.getTitle()}</h3>
                                    </c:when>   
                                </c:choose>          
                            </a>
                        </div>
                        <div class="panel-body">
                            <c:forEach var="textBody" items="${textUtil.getSubText200(material.getTextBody())}">
                                    <p>${textBody}</p>
                            </c:forEach>
                        </div>
                                <hr>
                    </c:forEach>
                    </div>
                </div>
            

        </div>
    </body>
</html>
