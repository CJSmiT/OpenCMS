<%-- 
    Document   : login
    Created on : 12.05.2018, 14:28:36
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <jsp:include page="headLinks.jsp" />
    </head>
    <body>     
        <div style="margin:0 auto; max-width: 900px; width:100%">
            <form class=".form-horizontal" method="post" action="login_action">
               <h3>Login</h3>
               <div>
                   <input type="text" 
                          name="login" 
                          style="width: 100%; height: 30px" 
                          required="required">
               </div>
               <h3>Password</h3>
               <div>
                   <input type="password" 
                          name="password" 
                          style="width: 100%; height: 30px"
                          required="required">
               </div>
               <input type="submit">
            </form>   
        </div>
    </body>
</html>
