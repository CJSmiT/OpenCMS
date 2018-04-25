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
        <title>Hello world!</title>
    </head>
    <body style="margin:10px;">
       <h3>Making a new material</h3>
       <div style="margin:0 auto; max-width: 500px; width:100%; background-color: yellowgreen">
       <form method="post" action="send_material">
           <p>Title </p>
           <input type="text" name="title"><br><br>
           <p>Text Body </p>
           <textarea name="textBody"></textarea><br>
           <p>Категория ID </p>
           
           <select name="categoryId">
           <c:forEach var="category" items="${categories}">
               <option value="${category.getId()}">${category.getTitle()}</option>
           </c:forEach>
           </select>
           
           <input type="submit">
       </form>
       
       
       <c:forEach var="material" items="${materials}">
           <ul>
                <li>${material.getTitle()}</li>
                <li>Hits ${material.getHits()}</li>
                <li>Категория ${material.getCategoryId()}</li>
                <li>Дата создания ${material.getTimePublic()}</li>
                <li>Опубликован  ${material.isIsPublic()}</li>
                <li>${material.getTextBody()}</li>
            </ul>
        </c:forEach>
        
       </div>
    </body>
</html>
