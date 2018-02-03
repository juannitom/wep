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
    JSONObject obj = new JSONObject();
    JSONArray arr = new JSONArray();
    Connexion mon = new Connexion();
    DBCursor cursor = null;
    int score = 0;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("coordonnees");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idmatchs").regex(Pattern.compile(request.getParameter("idmatchs"))).get(),
                            QueryBuilder.start("idUser").regex(Pattern.compile(request.getParameter("iduser"))).get()
                    ).get();
            cursor = table.find(query);
            int a = 0;
            while (cursor.hasNext()) {
                DBObject obje = cursor.next();
                String sco = String.valueOf(obje.get("point"));
                int scor = Integer.valueOf(sco);
                score = score+scor;
                a++;
            }
            arr.put(score);
            out.println(arr);
            response.setHeader("Access-Control-Allow-Origin", "*");
        } catch (MongoException e) {
            e.printStackTrace();
        }
%>