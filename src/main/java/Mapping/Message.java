/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

/**
 *
 * @author natha
 */
public class Message {
    private String id;
    private String destinateur;
    private String expediteur;
    private String message;

    public Message() {
    }

    public Message(String id, String destinateur, String expediteur, String message) {
        this.id = id;
        this.destinateur = destinateur;
        this.expediteur = expediteur;
        this.message = message;
    }

    public Message(String destinateur, String expediteur, String message) {
        this.destinateur = destinateur;
        this.expediteur = expediteur;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getDestinateur() {
        return destinateur;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public String getMessage() {
        return message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDestinateur(String destinateur) {
        this.destinateur = destinateur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
