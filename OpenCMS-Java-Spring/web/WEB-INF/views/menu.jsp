<%-- 
    Document   : menu
    Created on : 27.04.2018, 17:17:19
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div style="background-color: darkslategray; padding: 5px 0">
    <a href="${pageContext.request.contextPath}/home" style="color: whitesmoke; display: inline-block">
        <div style="width:150px; height: 40px;background-color: dimgray;margin: 5px">
            Home
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/material_manager" style="color: whitesmoke;display: inline-block">
        <div style="width:150px; height: 40px;background-color: dimgray;margin: 5px">
            Create material
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/categories" style="color: whitesmoke;display: inline-block">
        <div style="width:150px; height: 40px;background-color: dimgray;margin: 5px">
            Categories
        </div>
    </a>
    <a href="${pageContext.request.contextPath}/all_materials" style="color: whitesmoke;display: inline-block">
        <div style="width:150px; height: 40px;background-color: dimgray;margin: 5px">
            All materials
        </div>
    </a>
</div>
