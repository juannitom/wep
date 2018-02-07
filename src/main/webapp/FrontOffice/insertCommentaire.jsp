<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%@ page import="Mapping.*" %>
<%
    CommentaireDAO pub = new CommentaireDAO();
    String id = "COM_7";
    String idUser="UTL_2";
    String idPub=request.getParameter("idPub");
    PublicationDAO ut = new PublicationDAO();
    Publication rep = ut.findById(idPub);
    String commentaire = request.getParameter("commentaire");
    Commentaire com = new Commentaire(id, idUser, idPub, commentaire);
    pub.save(com);
    
    NotificationDAO not = new NotificationDAO();
    String idNot = "NOT_3";
    String actio = "commenté";
    PublicationDAO pu = new PublicationDAO();
    String daty = pu.getDatySystem();
    Publication coment = pu.findById(idPub);
    String idUserPost = coment.getIdUser();
    Notification n = new Notification(idNot, idUser, idUserPost, actio, idPub, daty);
    not.save(n);
    
    response.sendRedirect("detailPub.jsp?idPub="+ idPub +"");
%>