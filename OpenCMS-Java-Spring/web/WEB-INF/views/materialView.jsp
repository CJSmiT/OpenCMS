<%-- 
    Document   : materialView
    Created on : 27.04.2018, 18:15:51
    Author     : smit
--%>

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
            <h1>${material.getTitle()}</h1>
            <p>${material.getTextBody()}</p>
        </div>
    </body>
</html>
