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
import com.mongodb.MongoClientURI;

/**
 *
 * @author Bae
 */
public class Connexion {

    DB db;

    public DB getConnection() throws Exception {
        try {
            MongoClientURI mongo = new MongoClientURI("mongodb://anjara:anjara@ds125048.mlab.com:25048/dbweplay");
            MongoClient mongoclient = new MongoClient(mongo);
            db = mongoclient.getDB("dbweplay");

            System.out.println(db);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /* MongoClient mongo = new MongoClient("localhost", 27017);*/
        return db ;
    }
}
