<%-- 
    Document   : deleteJaime
    Created on : 6 févr. 2018, 11:19:55
    Author     : Nathalie Andrandrain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%@ page import="Mapping.*" %>
<%
    JaimeDAO jaim = new JaimeDAO();
    String idUser="UTL_1";
    String idPub = request.getParameter("idPub");
    jaim.delete(idPub, idUser);
%>
<jsp:forward page="publication.jsp" />