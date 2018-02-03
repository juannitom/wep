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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natha
 */
public class ActionDAO {
   Connexion mon = new Connexion();
   public DBCursor findById(String idPub) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("idPub", idPub);
            cursor = table.find(searchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return cursor;
    }
   /* public static int findCount(int idPub) throws Exception {
        int rep = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " select count(*) from jaime j join utilisateur u on j.idUser = u.id where idPub = ?";

        try {
            //conn = connexion.Connexion.getConnexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idPub);
            rs = ps.executeQuery();
            while (rs.next()) {
                rep = rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return rep;
    }*/
    public void save(Jaime ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", ajout.getId());
            document.put("idUser", ajout.getIdUser());
            document.put("idPub", ajout.getIdPub());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
      public void deleteUtilisateur(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("jaime");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
