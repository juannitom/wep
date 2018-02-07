/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Demande;
import Mapping.Notification;
import Mapping.Utilisateur;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import connexion.Connexion;
import Mapping.Publication;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;
/**
 *
 * @author natha
 */
public class NotificationDAO {
   Connexion mon = new Connexion();
       public void save(Notification ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("notification");
            BasicDBObject document = new BasicDBObject();
            document.put("idUser", ajout.getIdUser());
            document.put("idUser", ajout.getIdUser());
            document.put("idUserPost", ajout.getIdUserPost());
            document.put("actio", ajout.getAction());
            document.put("idPub", ajout.getIdPub());
            document.put("daty", ajout.getDaty());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
       
    public List<Notification> findById(String idUserPost) throws Exception {
        DBCursor cursor = null;
        List<Notification> p = new ArrayList<Notification>();
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("notification");
            DBObject query
                    = QueryBuilder.start().or(
                            QueryBuilder.start("idUserPost").regex(Pattern.compile(idUserPost)).get()
                    ).get();

            cursor = table.find(query);
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String id = String.valueOf(obj.get("id"));
                String idUser = String.valueOf(obj.get("idUser"));
                String actio = String.valueOf(obj.get("actio"));
                String idPub = String.valueOf(obj.get("idPub"));
                String daty = String.valueOf(obj.get("daty"));
                Notification nt = new Notification(id, idUser, idUserPost, actio, idPub, daty);
                p.add(nt);
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return p;
    }

}
