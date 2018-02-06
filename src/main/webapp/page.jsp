<%-- 
    Document   : index
    Created on : 30 janv. 2018, 09:45:39
    Author     : Mihanta
--%>

<%@page import="Service.UtilisateurDAO"%>
<%@page import="Mapping.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>test</h1>
        <p>hey</p>
        <% 
            out.println("hello");
        try {
            UtilisateurDAO pub = new UtilisateurDAO();
            Utilisateur[] list = pub.list();
            out.println(list.length);
            for(int i=0;i<list.length;i++){
               out.println(list[i].getId());
               out.println(list[i].getEmail());
               out.println(list[i].getEmploi());
               out.println(list[i].getNom());
               out.println(list[i].getSexe());
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        %>

    </body>
</html>
