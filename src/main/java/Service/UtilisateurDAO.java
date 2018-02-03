/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Mapping.Commentaire;
import Mapping.UserConnecte;
import Mapping.Utilisateur;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.QueryBuilder;
import connexion.Connexion;
import java.util.regex.Pattern;

/**
 *
 * @author natha
 */
public class UtilisateurDAO {

    Connexion mon = new Connexion();
    Utilisateur[] user = new Utilisateur[100];
    Utilisateur u;

    public Utilisateur[] list() throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("Utilisateur");
            BasicDBObject searchQuery = new BasicDBObject();

            cursor = table.find();

            int a = 0;

            while (cursor.hasNext()) {
                DBObject obj = cursor.next();
                String id = String.valueOf(obj.get("_id"));
                String nom = String.valueOf(obj.get("nom"));
                String email = String.valueOf(obj.get("email"));
                String mdp = String.valueOf(obj.get("mdp"));
                String sexe = String.valueOf(obj.get("sexe"));
                String emploi = String.valueOf(obj.get("emploi"));
                String photo = String.valueOf(obj.get("photo"));
                String score = String.valueOf(obj.get("score"));
                int score1 = Integer.valueOf(score);
                user[a] = new Utilisateur(id, nom, email, mdp, sexe, emploi, photo, score1);
                a++;

            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return user;
    }
    //findById(String id)

    public Utilisateur[] findById(String id) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("utilisateur");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("_id").regex(Pattern.compile(id)).get()
                    ).get();

            cursor = table.find(query);
            int a = 0;
            DBObject obj = null;
            while (cursor.hasNext()) {
                String nom = String.valueOf(obj.get("nom"));
                String email = String.valueOf(obj.get("email"));
                String mdp = String.valueOf(obj.get("mdp"));
                String sexe = String.valueOf(obj.get("sexe"));
                String emploi = String.valueOf(obj.get("emploi"));
                String photo = String.valueOf(obj.get("photo"));
                String score = String.valueOf(obj.get("score"));
                int score1 = Integer.valueOf(score);
                user[a] = new Utilisateur(id, nom, email, mdp, sexe, emploi, photo, score1);
                a++;

            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return user;
    }
        //findConnexion(String nom, String mdp)
    public Utilisateur findConnexion(String nom, String mdp) throws Exception {
        DBCursor cursor = null;
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("Utilisateur");
            DBObject query
                    = QueryBuilder.start().and(
                            QueryBuilder.start("nom").regex(Pattern.compile(nom)).get(),
                            QueryBuilder.start("mdp").regex(Pattern.compile(mdp)).get()
                    ).get();

            cursor = table.find(query);
            int a = 0;
            DBObject obj = null;
            while (cursor.hasNext()) {
                obj=cursor.next();
                String id = String.valueOf(obj.get("_id"));
                String email = String.valueOf(obj.get("email"));
                String sexe = String.valueOf(obj.get("sexe"));
                String emploi = String.valueOf(obj.get("emploi"));
                String photo = String.valueOf(obj.get("photo"));
                String score = String.valueOf(obj.get("score"));
                int score1 = Integer.valueOf(score);
                u = new Utilisateur(id, nom, email, mdp, sexe, emploi, photo, score1);
                a++;

            }

        } catch (MongoException e) {
            e.printStackTrace();
        }
        return u;
    }

    public void inscription(Utilisateur ajout) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("utilisateur");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", ajout.getId());
            document.put("nom", ajout.getNom());
            document.put("email", ajout.getEmail());
            document.put("mdp", ajout.getMdp());
            document.put("emploi", ajout.getEmploi());
            document.put("sexe", ajout.getSexe());
            document.put("photo", ajout.getPhoto());
            document.put("score", ajout.getScore());
            table.insert(document);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    public void updateUtilisateur(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("nom", up.getNom());
        newDocument.put("email", up.getEmail());
        newDocument.put("mdp", up.getMdp());
        newDocument.put("emploi", up.getEmploi());
        newDocument.put("sexe", up.getSexe());
        newDocument.put("photo", up.getPhoto());
        newDocument.put("score", up.getScore());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updateNom(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("nom", up.getNom());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updateEmail(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("email", up.getEmail());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updateMdp(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("mdp", up.getMdp());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updateEmploi(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("emploi", up.getEmploi());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updatePhoto(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("photo", up.getPhoto());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void updateScore(Utilisateur up) throws Exception {
        DB db = mon.getConnection();
        DBCollection table = db.getCollection("Utilisateur");

        BasicDBObject query = new BasicDBObject();
        query.put("_id", up.getId());

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("score", up.getScore());

        BasicDBObject updateObj = new BasicDBObject();
        updateObj.put("$set", newDocument);
        table.update(query, updateObj);
    }

    public void deleteUtilisateur(String id) throws Exception {
        try {
            DB db = mon.getConnection();
            DBCollection table = db.getCollection("Utilisateur");
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("_id", id);
            table.remove(searchQuery);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
    /*public static void Mail(){
       //L'adresse IP de votre serveur SMTP
       String smtpServer = "10.48.000.00";

       // L'adresse de l'expéditeur 
       String from = "monAdresse@monDomaine.fr";

       // L'adresse du destinataire 
       String to = "adresseDestinataire@domaine.fr";

       // L'objet du message 
       String objet = "Objet";

       // Le corps du mail 
       String texte = "Texte du mail";

       Properties props = System.getProperties();
       props.put("mail.smtp.host", smtpServer);
       // Session encapsule pour un client donné sa connexion avec le serveur de mails.
       Session session = Session.getDefaultInstance(props, null);

       // Création du message
       Message msg = new MimeMessage(session);

       try {
             msg.setFrom(new InternetAddress(from));
             msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to, false));
             msg.setSubject(objet);
             msg.setText(texte);
             msg.setHeader("X-Mailer", "LOTONtechEmail");
             Transport.send(msg);
       }
       catch (AddressException e) {
             e.printStackTrace();
       } 
       catch (MessagingException e) {
             e.printStackTrace();
       }
     }*/
}
