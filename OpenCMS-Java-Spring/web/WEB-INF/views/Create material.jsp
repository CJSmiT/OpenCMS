<%-- 
    Document   : Create material
    Created on : 27.04.2018, 16:57:08
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Making a new material</title>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        
        <div style="margin:0 auto; max-width: 900px; width:100%">
            <h1>Создания материала</h1>

            <form method="post" action="send_material">
               <h3>Заголовок</h3>
               <div><input type="text" name="title" style="width: 100%; height: 30px"></div>
               <h3>Категория</h3>
               <div>
                   <select name="categoryId" style="width: 100%; height: 30px">
                       <c:forEach var="category" items="${categories}">
                           <option value="${category.getId()}">${category.getTitle()}</option>
                       </c:forEach>
                   </select>
               </div>
               <h3>Статус</h3>
               <div>
                    <select name="isPublic" style="width: 100%; height: 30px">
                        <option value="false">Не публиковать</option>
                        <option value="true">Опубликовать</option>
                    </select>
               </div>
               <h3>Материал</h3>
               <div>
                   <textarea name="textBody" style="width: 100%; height: 150px"></textarea>
               </div>
               <div>
                   <input type="submit" style="width: 100%; height: 30px; color: blue">
               </div>
            </form>
            </div>
    </body>
</html>
