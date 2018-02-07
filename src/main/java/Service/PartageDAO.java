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
import com.mongodb.QueryBuilder;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author natha
 */
public class PartageDAO {

    Connexion mon = new Connexion();

    public DBCursor findById(String idPub) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("partage");
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
//fonction findCount(int idPub)
    public int findCount(String idPub) throws Exception {
        DBCursor cursor = null;
        int count = 0;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("partage");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idPub").regex(Pattern.compile(idPub)).get()
                    ).get();

            cursor = table.find(query);
            count = cursor.count();

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return count;
    }
    public void save(Partage ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("partage");
            BasicDBObject document = new BasicDBObject();
            document.put("idUser", ajout.getIdUser());
            document.put("idPub", ajout.getIdPub());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
