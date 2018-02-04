/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;

/**
 *
 * @author natha
 */
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 *
 * @author Bae
 */
public class Connexion {

    DB db;

    public DB getConnection() throws Exception {
      // MongoClient mongo = new MongoClient("ds119018.mlab.com", 19018);
        //return db = mongo.getDB("weplay");
        MongoClient mongo = new MongoClient("localhost", 27017);
        return db = mongo.getDB("weplay");
    }
}
