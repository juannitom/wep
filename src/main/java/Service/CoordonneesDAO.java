/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Mapping.Coordonnees;
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
public class CoordonneesDAO {

    Connexion mon = new Connexion();

    public int getTotalPoint(String idmatch, String idUser) throws Exception {
        DBCursor cursor = null;
        int score = 0;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("coordonnees");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("idmatchs").regex(Pattern.compile(idmatch)).get(),
                            QueryBuilder.start("idUser").regex(Pattern.compile(idUser)).get()
                    ).get();
            cursor = table.find(query);
            int a = 0;
            DBObject obj = null;
            while (cursor.hasNext()) {
                obj = cursor.next();
                String sco = String.valueOf(obj.get("point"));
                int scor = Integer.valueOf(sco);
                score = score+scor;
                a++;

            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return score;
    }

    public void saveCoordonnees(Coordonnees coord) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("coordonnees");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", coord.getId());
            document.put("idmatchs", coord.getIdmatch());
            document.put("idUser", coord.getIdutilisateur());
            document.put("x", coord.getX());
            document.put("y", coord.getY());
            document.put("types", coord.getTypes());
            document.put("point", coord.getPoint());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
