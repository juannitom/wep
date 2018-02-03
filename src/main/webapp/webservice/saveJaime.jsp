<%-- 
    Document   : listUtilisateur
    Created on : 31 déc. 2017, 11:54:55
    Author     : Mihanta
--%>


<%@page import="Service.MatchsDAO"%>
<%@page import="Service.CommentaireDAO"%>
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
    JSONArray arr = new JSONArray();
    Connexion mon = new Connexion();
    MatchsDAO mat = new MatchsDAO();
    String nouveau = mat.nouveauId(mat.getDernier("jaime"));
    try {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("jaime");
        BasicDBObject document = new BasicDBObject();
        document.put("_id", nouveau);
        document.put("idUser", request.getParameter("idUser"));
        document.put("idPub",  request.getParameter("idPub"));
        table.insert(document);
        arr.put(document);
        obj = new JSONObject();
        out.println("hey"+arr);
        response.setHeader("Access-Control-Allow-Origin", "*");
    } catch (MongoException e) {
        e.printStackTrace();
    }

%>