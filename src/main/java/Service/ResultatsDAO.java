/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Resultats;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;
import connexion.Connexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Mihanta
 */
public class ResultatsDAO {

    Connexion mon = new Connexion();

    public void saveResultats(Resultats res) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("resultats");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", res.getId());
            document.put("idmatch", res.getIdmatch());
            document.put("resultat1", res.getResultat1());
            document.put("resultat2", res.getResultat2());
            document.put("gagnant", res.getGagnant());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
