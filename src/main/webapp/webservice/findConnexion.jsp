<%-- 
    Document   : listUtilisateur
    Created on : 31 d�c. 2017, 11:54:55
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
    JSONObject obj = new JSONObject();
    JSONArray arr = new JSONArray();
    Connexion mon = new Connexion();
    DBCursor cursor = null;
    try {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("utilisateur");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("nom").regex(Pattern.compile(request.getParameter("nom"))).get(),
                            QueryBuilder.start("mdp").regex(Pattern.compile(request.getParameter("mdp"))).get()
                    ).get();

            cursor = table.find(query);
        while (cursor.hasNext()) {
            DBObject obje = cursor.next();
            obj.put("_id", obje.get("_id"));
            obj.put("email", obje.get("email"));
            obj.put("sexe", obje.get("sexe"));
            obj.put("photo", obje.get("photo"));
            obj.put("score", obje.get("score"));
            arr.put(obj);
            obj = new JSONObject();
        }
        out.println(arr);
        response.setHeader("Access-Control-Allow-Origin", "*");

    } catch (MongoException e) {
        e.getMessage();
    }

%>