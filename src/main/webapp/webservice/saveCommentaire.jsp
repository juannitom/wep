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
      //Commentaire ajout = new Commentaire(id,iduser,idpub,coms);
      // CommentaireDAO com = new CommentaireDAO();
     // response.setHeader("Access-Control-Allow-Origin", "*");
     // obj.put("rep", com.save(ajout));
    //  arr.put(obj);
    //obj = new JSONObject();
    MatchsDAO mat = new MatchsDAO();
    String nouveau = mat.nouveauId(mat.getDernier("commentaire"));
    try {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("commentaire");
        BasicDBObject document = new BasicDBObject();
        document.put("_id", nouveau);
        document.put("idUser", request.getParameter("iduser"));
        document.put("idPub",  request.getParameter("idpub"));
        document.put("commentaire",  request.getParameter("cms"));
        table.insert(document);
        arr.put(document);
        obj = new JSONObject();
        out.println("hey"+arr);
        response.setHeader("Access-Control-Allow-Origin", "*");
    } catch (MongoException e) {
        e.printStackTrace();
    }

%>