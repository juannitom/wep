<%-- 
    Document   : insertPublication
    Created on : 1 févr. 2018, 21:16:50
    Author     : Nathalie Andrandrain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%@ page import="Mapping.*" %>
<%
    JaimeDAO jaim = new JaimeDAO();
    String id = "JM_6";
    String idUser="UTL_1";
    String idPub = request.getParameter("idPub");
    Jaime j = new Jaime(id, idUser, idPub);
    jaim.save(j);
    
    NotificationDAO not = new NotificationDAO();
    String idNot = "NOT_3";
    String actio = "commenté";
    PublicationDAO pu = new PublicationDAO();
    String daty = pu.getDatySystem();
    Publication coment = pu.findById(idPub);
    String idUserPost = coment.getIdUser();
    Notification n = new Notification(idNot, idUser, idUserPost, actio, idPub, daty);
    not.save(n);
%>
<jsp:forward page="publication.jsp" />