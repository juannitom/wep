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
public class Utilisateur {
  private String id;
  private String nom;
  private String email;
  private String mdp;
  private String sexe;
  private String emploi;
  private String photo;
  private int score;

    public Utilisateur() {
    }

  
    public Utilisateur(String id, String nom, String email, String mdp, String sexe, String emploi, String photo, int score) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.sexe = sexe;
        this.emploi = emploi;
        this.photo = photo;
        this.score = score;
    }
     public Utilisateur(String nom, String email, String mdp, String sexe, String emploi, String photo, int score, String id) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.sexe = sexe;
        this.emploi = emploi;
        this.photo = photo;
        this.score = score;
    }

    public Utilisateur(String nom, String email, String mdp, String sexe, String emploi, String photo, int score) {
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;
        this.sexe = sexe;
        this.emploi = emploi;
        this.photo = photo;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getSexe() {
        return sexe;
    }

    public String getEmploi() {
        return emploi;
    }

    public String getPhoto() {
        return photo;
    }

    public int getScore() {
        return score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setScore(int score) {
        this.score = score;
    }
  
  
}

