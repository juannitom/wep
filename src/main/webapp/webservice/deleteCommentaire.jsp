<%-- 
    Document   : deleteCommentaire
    Created on : 31 déc. 2017, 11:54:55
    Author     : Mihanta
--%>


<%@page import="Mapping.Commentaire"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.MongoException"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="com.mongodb.QueryBuilder"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="connexion.Connexion"%>
<%@page import="com.mongodb.DB"%>
<%@page import="com.mongodb.DBCursor"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>

<%
    JSONObject obj = new JSONObject();
    Connexion mon = new Connexion();
    try {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("commentaire");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", request.getParameter("id"));
        table.remove(searchQuery);
        response.setHeader("Access-Control-Allow-Origin", "*");
    } catch (MongoException e) {
        e.printStackTrace();
    }

%>