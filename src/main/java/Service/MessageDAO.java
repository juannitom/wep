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


/**
 *
 * @author natha
 */
public class MessageDAO {
        Connexion mon = new Connexion();
        //find(String destinateur, String expediteur)
        public DBCursor find(String destinateur, String expediteur) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("destinateur", destinateur);
            searchQuery.put("expediteur", expediteur);
            cursor = table.find(searchQuery);
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return cursor;
    }
            public void inscription(Message ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", ajout.getId());
            document.put("destinateur", ajout.getDestinateur());
            document.put("expediteur", ajout.getExpediteur());
            document.put("message", ajout.getMessage());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
     public void delete(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("message");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
      /*public static List<Message> envoye(int expediteur, int destinateur)
      {
            List<Message> valiny = new ArrayList<Message>();
        try {
            //List<Message> ms = find(expediteur, destinateur);
             for(int i = 0; i<ms.size(); i++)
            {
                //if(ms.get(i).getExpediteur()== expediteur)
                {
                    Message mes = new Message();
                    mes.setId(ms.get(i).getId());
                    mes.setDestinateur(ms.get(i).getExpediteur());
                    mes.setExpediteur(ms.get(i).getDestinateur());
                    mes.setMessage(ms.get(i).getMessage());
                
                valiny.add(mes);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valiny;
      }
      public static List<Message> reception(int expediteur, int destinateur)
      {
            List<Message> valiny = new ArrayList<Message>();
        try {
            //List<Message> ms = find(expediteur, destinateur);
             for(int i = 0; i<ms.size(); i++)
            {
                //if(ms.get(i).getExpediteur()== destinateur)
                {
                    Message mes = new Message();
                    mes.setId(ms.get(i).getId());
                    mes.setDestinateur(ms.get(i).getExpediteur());
                    mes.setExpediteur(ms.get(i).getDestinateur());
                    mes.setMessage(ms.get(i).getMessage());
                
                valiny.add(mes);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valiny;
      }*/
}
