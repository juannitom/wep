<%-- 
    Document   : index
    Created on : 30 janv. 2018, 09:45:39
    Author     : Mihanta
--%>

<%@page import="Service.CoordonneesDAO"%>
<%@page import="Service.MatchsDAO"%>
<%@page import="Mapping.UserConnecte"%>
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
        UserConnecte match = new UserConnecte("co","UTL_1");
        out.println(match.getId());
        out.println(match.getIdUser());
        %>
    </body>
</html>
