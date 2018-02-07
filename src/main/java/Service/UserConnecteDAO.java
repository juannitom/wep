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
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natha
 */
public class UserConnecteDAO {

    Connexion mon = new Connexion();

    public List<UserConnecte> list() throws Exception {
        DBCursor cursor = null;
        List<UserConnecte> rep = new ArrayList<UserConnecte>();
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("userConnecte");
            BasicDBObject searchQuery = new BasicDBObject();

            cursor = table.find();

            int a = 0;

            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String id = String.valueOf(obj.get("_id"));
                String idUser = String.valueOf(obj.get("idUser"));
                UserConnecte us = new UserConnecte(id, idUser);
                rep.add(us);
            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return rep;
    }

    public void connexion(String id, String idUser) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("userConnecte");
            BasicDBObject document = new BasicDBObject();
            document.put("idUser", idUser);
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void deconnexion(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("userConnecte");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("idUser", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
