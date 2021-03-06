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
        DBCollection table = db.getCollection("demande");
        DBObject query
                = QueryBuilder.start().and(
                        QueryBuilder.start("iddemande").regex(Pattern.compile(request.getParameter("iduser"))).get()
                ).get();

        cursor = table.find(query);
        while (cursor.hasNext()) {
            DBObject obje = cursor.next();
            obj.put("_id", obje.get("_id"));
            obj.put("iddemandeur", obje.get("iddemandeur"));
            obj.put("iddemande", obje.get("iddemande"));
            arr.put(obj);
            obj = new JSONObject();
        }
        out.println(arr);
        response.setHeader("Access-Control-Allow-Origin", "*");

    } catch (MongoException e) {
        e.getMessage();
    }

%>