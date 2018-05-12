<%-- 
    Document   : menu
    Created on : 27.04.2018, 17:17:19
    Author     : smit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">My Site</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
      <li><a href="${pageContext.request.contextPath}/material_manager">Create material</a></li>
      <li><a href="${pageContext.request.contextPath}/categories">Categories</a></li>
      <li><a href="${pageContext.request.contextPath}/all_materials">All materials</a></li>
    </ul>
  </div>
</nav>
