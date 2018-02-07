/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import connexion.Connexion;
import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 *
 * @author natha
 */
public class MessageDAO {
        Connexion mon = new Connexion();
       
        public List<Message> findMessage(String destinateur, String expediteur) throws Exception {
        DBCursor cursor = null;
        List<Message> rep = new ArrayList<Message>();
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            DBObject query
                    = QueryBuilder.start().or(
                            QueryBuilder.start("destinateur").regex(Pattern.compile(destinateur)).get(),
                            QueryBuilder.start("expediteur").regex(Pattern.compile(expediteur)).get()
                    ).get();

            cursor = table.find(query);
            DBObject obj = null;
            while (cursor.hasNext()) {
                obj=cursor.next();
                String id = String.valueOf(obj.get("_id"));
                destinateur = String.valueOf(obj.get("destinateur"));
                expediteur = String.valueOf(obj.get("expediteur"));
                String message = String.valueOf(obj.get("message"));
                Message m = new Message(id, destinateur, expediteur, message);
                rep.add(m);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return rep;
    }
        
        public List<Message> findMess(String destinateur, String expediteur) throws Exception {
        DBCursor cursor = null;
        List<Message> rep = new ArrayList<Message>();
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("destinateur").regex(Pattern.compile(destinateur)).get(),
                            QueryBuilder.start("expediteur").regex(Pattern.compile(expediteur)).get()
                    ).get();

            cursor = table.find(query);
            DBObject obj = null;
            while (cursor.hasNext()) {
                obj=cursor.next();
                String id = String.valueOf(obj.get("_id"));
                destinateur = String.valueOf(obj.get("destinateur"));
                expediteur = String.valueOf(obj.get("expediteur"));
                String message = String.valueOf(obj.get("message"));
                Message m = new Message(id, destinateur, expediteur, message);
                rep.add(m);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return rep;
    }
        
        public void save(Message ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            BasicDBObject document = new BasicDBObject();
            document.put("destinateur", ajout.getDestinateur());
            document.put("expediteur", ajout.getExpediteur());
            document.put("message", ajout.getMessage());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
     public void delete(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
