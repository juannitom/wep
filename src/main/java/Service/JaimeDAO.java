/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Commentaire;
import Mapping.Jaime;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import connexion.Connexion;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author natha
 */
public class JaimeDAO {

    Connexion mon = new Connexion();
    Jaime u;

    public List<Jaime> findById(String idpub) throws Exception {
        DBCursor cursor = null;
        List<Jaime> rep = new ArrayList<Jaime>();
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idPub").regex(Pattern.compile(idpub)).get()
                    ).get();

            cursor = table.find(query);
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String id = String.valueOf(obj.get("_id"));
                String idu = String.valueOf(obj.get("idUser"));
                String idp = String.valueOf(obj.get("idPub"));
                Jaime j = new Jaime(id, idu, idp);
                rep.add(j);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return rep;
    }

    //fonction findCount(int idPub)
    
    public int findJaime(String idPub, String idUser) throws Exception {
        DBCursor cursor = null;
        int count = 0;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idPub").regex(Pattern.compile(idPub)).get(),
                            QueryBuilder.start("idUser").regex(Pattern.compile(idUser)).get()
                    ).get();

            cursor = table.find(query);
            count = cursor.count();

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return count;
    }
    
      public int findCount(String idPub) throws Exception {
        DBCursor cursor = null;
        int count = 0;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            DBObject query
                    = QueryBuilder.start().or(
                            QueryBuilder.start("idPub").regex(Pattern.compile(idPub)).get()
                    ).get();

            cursor = table.find(query);
            count = cursor.count();

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void save(Jaime ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            BasicDBObject document = new BasicDBObject();
            document.put("idUser", ajout.getIdUser());
            document.put("idPub", ajout.getIdPub());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
       public void delete(String idPub, String idUser) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("idPub", idPub);
            searchQuery.put("idUser", idUser);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
