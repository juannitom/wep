<%-- 
    Document   : deconnexion
    Created on : 6 févr. 2018, 21:28:05
    Author     : Nathalie Andrandrain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%@ page import="Mapping.*" %>
<%
    UserConnecteDAO user = new UserConnecteDAO();
    String idUser="UTL_1";
    user.deconnexion(idUser);
    response.sendRedirect("../index.jsp");
%>