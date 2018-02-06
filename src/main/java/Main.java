
import Mapping.Commentaire;
import Mapping.Publication;
import Mapping.Utilisateur;
import Service.CommentaireDAO;
import Service.CoordonneesDAO;
import Service.MatchsDAO;
import Service.PublicationDAO;
import Service.UtilisateurDAO;
import com.mongodb.DBCursor;
import org.omg.CORBA.MARSHAL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mihanta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            UtilisateurDAO pub = new UtilisateurDAO();
            Utilisateur[] list = pub.list();
            for(int i=0;i<list.length;i++){
                System.out.println("heheh"+list[i].getId());
                System.out.println(list[i].getEmail());
                System.out.println(list[i].getEmploi());
                System.out.println(list[i].getNom());
                System.out.println(list[i].getSexe());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
