<%-- 
    Document   : material_manager
    Created on : 08.05.2018, 16:32:02
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Material manager</title>
        <jsp:include page="headLinks.jsp" />
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div style="margin:0 auto; max-width: 900px; width:100%">
            <h1>Material manager</h1>
            <c:if test="${material!=null}">
                
                    <c:choose>
                        <c:when test="${material.isIsPublic() == false}">
                            <a class="btn btn-success" href="${pageContext.request.contextPath}/change_public_status_material?alias=${material.getAlias()}&public=true">Set as public</a>
                        </c:when> 
                        <c:otherwise>
                            <a class="btn btn-danger" href="${pageContext.request.contextPath}/change_public_status_material?alias=${material.getAlias()}&public=false">Set as UnPublc</a>
                        </c:otherwise>
                    </c:choose>
                <div style="display: inline-block"> 
                    <a href="${pageContext.request.contextPath}/delete_material?idMaterial=${material.getId()}">
                        <button type="button" class="btn btn-danger">Delete</button>
                    </a>
                </div>
                </c:if>
            <form method="post" action="material_manager_action">
                <c:if test="${material!=null}">
                    <input type="hidden" name="id" value="${material.getId()}">
                    <input type="hidden" name="isPublic" value="${material.isIsPublic()}"> 
                </c:if>
               <h3>Заголовок</h3>
               <input type="text" name="title" value="${material.getTitle()}" style="width: 100%; height: 30px">
               <h3>Категория</h3>
               <div>
                   <select name="categoryId" style="width: 100%; height: 30px">
                       <c:forEach var="category" items="${categories}">
                           <option value="${category.getId()}" 
                                   <c:if test="${category.getId()== material.getCategoryId()}">
                                       selected
                                   </c:if>
                                       >${category.getTitle()}</option>
                       </c:forEach>
                   </select>
               </div>
               <h3>Материал</h3>
               <textarea name="textBody" style="width: 100%; height: 150px">${material.getTextBody()}</textarea>
               <input type="submit" style="width: 100%; height: 30px; color: blue">
            </form>
            </div>
        
    </body>
</html>
