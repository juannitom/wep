<%-- 
    Document   : index
    Created on : 30 janv. 2018, 09:45:39
    Author     : Mihanta
--%>

<%@page import="Service.CoordonneesDAO"%>
<%@page import="Service.MatchsDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>test</h1>
        <%
            try {
                MatchsDAO match = new MatchsDAO();
                CoordonneesDAO coord = new CoordonneesDAO();
                int score = coord.getTotalPoint("matchs_1", "UTL_1");
                out.println("score : " + score);
                String id = match.getDernier("matchs");
                out.println(id);
                String next = match.nouveauId(id);
                out.println(next);
            } catch (Exception e) {
                out.println(e.getMessage());
            }
        %>
    </body>
</html>
