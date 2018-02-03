/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Publication;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import connexion.Connexion;
import java.util.regex.Pattern;

/**
 *
 * @author natha
 */
public class PublicationDAO {

    Connexion mon = new Connexion();
    Publication[] publication = new Publication[100];
//

    public Publication[] list() throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            
            cursor = table.find();

            int a = 0;

            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String id = String.valueOf(obj.get("_id"));
                String idUser = String.valueOf(obj.get("idUser"));
                String description = String.valueOf(obj.get("description"));
                String photo = String.valueOf(obj.get("photo"));
                String daty = String.valueOf(obj.get("daty"));
                publication[a] = new Publication(id, idUser, description, photo, daty);
                a++;

            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return publication;
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

    public Publication[] findById(String idUser) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("publication");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idUser").regex(Pattern.compile(idUser)).get()
                    ).get();

            cursor = table.find(query);
            int a = 0;
            DBObject obj = null;
            while (cursor.hasNext()) {
                String id = String.valueOf(obj.get("_id"));
                String description = String.valueOf(obj.get("description"));
                String photo = String.valueOf(obj.get("photo"));
                String daty = String.valueOf(obj.get("daty"));
                publication[a] = new Publication(id, idUser, description, photo, daty);
                a++;

            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return publication;
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
}
