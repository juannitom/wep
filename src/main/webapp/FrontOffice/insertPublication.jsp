<%-- 
    Document   : insertPublication
    Created on : 1 févr. 2018, 21:16:50
    Author     : Nathalie Andrandrain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%@ page import="Mapping.*" %>
<%
    PublicationDAO pub = new PublicationDAO();
    String id = "PUB_3";
    String idUser="UTL_1";
    String description=request.getParameter("desc");
    String photo=request.getParameter("photo");
    String daty=pub.getDatySystem();
    Publication p = new Publication(id, idUser, description, photo, daty);
    pub.save(p);
%>
<jsp:forward page="publication.jsp" />