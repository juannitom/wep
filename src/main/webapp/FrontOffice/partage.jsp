<%-- 
    Document   : partage
    Created on : 6 févr. 2018, 22:07:53
    Author     : Nathalie Andrandrain
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%@ page import="Mapping.*" %>
<%
    PartageDAO jaim = new PartageDAO();
    String id = "PRTG_2";
    String idUser="UTL_1";
    String idPub = request.getParameter("idPub");
    Partage j = new Partage(id, idUser, idPub);
    jaim.save(j);
    
    NotificationDAO not = new NotificationDAO();
    String idNot = "NOT_3";
    String actio = "commenté";
    PublicationDAO pu = new PublicationDAO();
    String daty = pu.getDatySystem();
    Publication coment = pu.findById(idPub);
    
    String idPubli = "PUB_4";
    String description = coment.getDescription();
    String photo = coment.getPhoto();
    String dat = coment.getDaty();
    Publication p = new Publication(idPubli, idUser, description, photo, dat);
    pu.save(p);
    
    
    String idUserPost = coment.getIdUser();
    Notification n = new Notification(idNot, idUser, idUserPost, actio, idPub, daty);
    not.save(n);
     response.sendRedirect("publication.jsp");
%>
