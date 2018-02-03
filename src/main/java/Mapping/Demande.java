/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

/**
 *
 * @author Mihanta
 */
public class Demande {

    private String id;
    private String iddemandeur;
    private String iddemande;

    public Demande() {
    }

    public Demande(String id, String iddemandeur, String iddemande) {
        this.id = id;
        this.iddemandeur = iddemandeur;
        this.iddemande = iddemande;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIddemandeur() {
        return iddemandeur;
    }

    public void setIddemandeur(String iddemandeur) {
        this.iddemandeur = iddemandeur;
    }

    public String getIddemande() {
        return iddemande;
    }

    public void setIddemande(String iddemande) {
        this.iddemande = iddemande;
    }

    
}
