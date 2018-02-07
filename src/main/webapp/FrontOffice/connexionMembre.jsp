<%-- 
    Document   : connexionMembre
    Created on : 29 janv. 2018, 20:10:11
    Author     : Nathalie Andrandrain
--%>

<%@page import="Mapping.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Service.*" %>
<%
    UtilisateurDAO ut = new UtilisateurDAO();
    String nom = request.getParameter("nom");
    String mdp = request.getParameter("mdp");
    Utilisateur u = ut.findConnexion(nom, mdp);
    UserConnecteDAO user = new UserConnecteDAO();
    if(nom.equals(u.getNom())&& mdp.equals(u.getMdp()))
    {
        String id = "UC_3";
        String idUser = u.getId();
        user.connexion(id, idUser);
%>
    <jsp:forward page="publication.jsp" />
<%}
else
{%>
    <jsp:forward page="../index.jsp" />
    
    <%}%>
