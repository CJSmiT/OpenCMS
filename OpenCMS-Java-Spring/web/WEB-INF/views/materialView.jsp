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
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div style="margin:0 auto;max-width: 1000px; width: 100%">
            <c:choose>
                <c:when test="${material.isIsPublic() == false}">
                    <div>
                        <a href="set_material_public" style="color: whitesmoke;display: inline-block">
                            <div style="width:150px; height: 40px;background-color: dimgray;margin: 5px">
                            Опубликовать
                            </div>
                        </a>
                    </div> 
                    <br />
                </c:when> 
                <c:when test="${material.isIsPublic() == true}">
                    <div>
                        <a href="set_material_no_public" style="color: whitesmoke;display: inline-block">
                            <div style="width:150px; height: 40px;background-color: dimgray;margin: 5px">
                            Не публиковать
                            </div>
                        </a>
                    </div> 
                    <br />
                </c:when>   
                <c:otherwise>
                    Что-то пошло не так ....
                    <br />
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${material.isIsPublic() == false}">
                    <h1 style="color: red">${material.getTitle()}</h1>
                </c:when> 
                <c:when test="${material.isIsPublic() == true}">
                    <h1 style="color: green">${material.getTitle()}</h1>
                </c:when>   
                <c:otherwise>
                    Что-то пошло не так ....
                    <br />
                </c:otherwise>
            </c:choose>                
            <p>${material.getTextBody()}</p>
        </div>
    </body>
</html>