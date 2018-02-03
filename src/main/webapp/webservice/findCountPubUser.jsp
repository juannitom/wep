<%-- 
    Document   : listUtilisateur
    Created on : 31 déc. 2017, 11:54:55
    Author     : Mihanta
--%>


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
    JSONArray arr = new JSONArray();
    Connexion mon = new Connexion();
    DBCursor cursor = null;

    int count = 0;
    try {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("publication");
        DBObject query
                = QueryBuilder.start().or(
                        QueryBuilder.start("idUser").regex(Pattern.compile(request.getParameter("idUser"))).get()
                ).get();

        cursor = table.find(query);
        count = cursor.count();
        arr.put(count);
        out.println(arr);
        response.setHeader("Access-Control-Allow-Origin", "*");
    } catch (MongoException e) {

        e.printStackTrace();
    }

%>