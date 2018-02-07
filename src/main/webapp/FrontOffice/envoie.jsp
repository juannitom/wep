<%-- 
    Document   : envoie
    Created on : 7 févr. 2018, 10:02:30
    Author     : Nathalie Andrandrain
--%>

<%@page import="Mapping.Message"%>
<%@page import="Service.MessageDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% MessageDAO ms = new MessageDAO();
   String exp = "UTL_1";
   String des = request.getParameter("exp");
   String mes = request.getParameter("mes");
   Message m = new Message(des, exp, mes);
   ms.save(m);
%>