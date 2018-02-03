/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Demande;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Mihanta
 */
public class DemandeDAO {

    Connexion mon = new Connexion();
    Demande[] demande = new Demande[100];
    //getListDemande(iduser)

    public Demande[] getListDemande(String iduser) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("demande");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("iddemande").regex(Pattern.compile(iduser)).get()
                    ).get();

            cursor = table.find(query);

            int a = 0;

            while (cursor.hasNext()) {
                DBObject obj = cursor.next();

                String id = String.valueOf(obj.get("_id"));
                String iddemandeur = String.valueOf(obj.get("iddemandeur"));
                String iddemande = String.valueOf(obj.get("iddemande"));
                demande[a] = new Demande(id, iddemandeur, iddemande);
                a++;

            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return demande;
    }

    public void saveDemande(Demande d) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("demande");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", d.getId());
            document.put("iddemandeur", d.getIddemandeur());
            document.put("iddemande", d.getIddemande());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

}
