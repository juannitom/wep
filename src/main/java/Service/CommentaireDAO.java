/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Commentaire;
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
public class CommentaireDAO {

    Connexion mon = new Connexion();
    Commentaire u;

    //fonction findById(String id)
    public List<Commentaire> findByIdPub(String idPub) throws Exception {
        DBCursor cursor = null;
        List<Commentaire> com = new ArrayList<Commentaire>();
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("commentaire");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idPub").regex(Pattern.compile(idPub)).get()
                    ).get();

            cursor = table.find(query);
            DBObject obj = null;
            while (cursor.hasNext()) {
                obj=cursor.next();
                String iduser = String.valueOf(obj.get("idUser"));
                String id = String.valueOf(obj.get("id"));
                String commentaire = String.valueOf(obj.get("commentaire"));
                u = new Commentaire(id, iduser, idPub, commentaire);
                com.add(u);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return com;
    }
    public void save(Commentaire ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("commentaire");
            BasicDBObject document = new BasicDBObject();
            document.put("idUser", ajout.getIdUser());
            document.put("idPub", ajout.getIdPub());
            document.put("commentaire", ajout.getCommentaire());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("Commentaire");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
