/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Demande;
import Mapping.Publication;
import Mapping.Utilisateur;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import connexion.Connexion;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author natha
 */
public class PublicationDAO {

    Connexion mon = new Connexion();
    Publication[] publication = new Publication[100];
//

    public List<Publication> list() throws Exception {
        List<Publication> rep = new ArrayList<Publication>(); 
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            BasicDBObject searchQuery = new BasicDBObject();

            cursor = table.find();

            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String id = String.valueOf(obj.get("_id"));
                String idUser = String.valueOf(obj.get("idUser"));
                String description = String.valueOf(obj.get("description"));
                String photo = String.valueOf(obj.get("photo"));
                String daty = String.valueOf(obj.get("daty"));
                Publication p = new Publication(id, idUser, description, photo, daty);
                rep.add(p);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return rep;
    }

         public void save(Publication ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            BasicDBObject document = new BasicDBObject();
            document.put("idUser", ajout.getIdUser());
            document.put("description", ajout.getDescription());
            document.put("photo", ajout.getPhoto());
            document.put("daty", ajout.getDaty());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
         
    public void delete(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public Publication findById(String id) throws Exception {
        DBCursor cursor = null;
        Publication p = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            DBObject query
                    = QueryBuilder.start().or(
                            QueryBuilder.start("_id").regex(Pattern.compile(id)).get()
                    ).get();

            cursor = table.find(query);
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String idUser = String.valueOf(obj.get("idUser"));
                String description = String.valueOf(obj.get("description"));
                String photo = String.valueOf(obj.get("photo"));
                String daty = String.valueOf(obj.get("daty"));
                p = new Publication(id, idUser, description, photo, daty);
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return p;
    }

    //findNbPubUser(int idUser)
    public int findNbPubUser(String idUser) throws Exception {
        DBCursor cursor = null;
        int count = 0;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idUser").regex(Pattern.compile(idUser)).get()
                    ).get();

            cursor = table.find(query);
            count = cursor.count();

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void updatePhoto(Publication up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("publication");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("photo", up.getPhoto());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updateDescription(Publication up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("publication");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("description", up.getDescription());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }
     public String getDatySystem(){
        Calendar datyAndroany = Calendar.getInstance();
            
            int jour = datyAndroany.get(Calendar.DAY_OF_MONTH);
            int m = datyAndroany.get(Calendar.MONTH);
            int ans = datyAndroany.get(Calendar.YEAR);
            
             int mois = m+1;
             
             return ans+"-"+mois+"-"+jour;             
    }
}
