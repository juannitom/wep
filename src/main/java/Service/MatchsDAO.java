/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Action;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Mapping.Matchs;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import java.util.regex.Pattern;

/**
 *
 * @author Mihanta
 */
public class MatchsDAO {

    Connexion mon = new Connexion();
    //findById(idPub)
    Matchs[] matchs = new Matchs[500];
    Matchs u;

    //getDernierIdMatch()
    public String getDernier(String nomCollection) throws Exception {
        DBCursor cursor = null;
        String idmatch = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection(nomCollection);
            cursor = table.find().sort(new BasicDBObject("_id", -1)).limit(1);
            for (DBObject dbObject : cursor) {
                idmatch = (String)dbObject.get("_id");
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return idmatch;
    }
    public String nouveauId(String lastId) throws Exception{
        String nouveau ="";
        String [] tab = lastId.split("_");
        int next = Integer.valueOf(tab[1])+1;
        nouveau = tab[0]+"_"+String.valueOf(next);
        return nouveau;
    }
    

    public void saveMatchs(Matchs matchs) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("matchs");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", matchs.getId());
            document.put("idUser1", matchs.getIduser1());
            document.put("idUser2", matchs.getIduser2());
            document.put("datematch", matchs.getDatematch());
            document.put("etat", matchs.getEtat());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
