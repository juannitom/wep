/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapping;

import java.sql.Date;

/**
 *
 * @author Mihanta
 */
public class Matchs {

    private String id;
    private String iduser1;
    private String iduser2;
    private String datematch;
    private String etat;

    public Matchs(String id, String iduser1, String iduser2, String datematch, String etat) {
        this.id = id;
        this.iduser1 = iduser1;
        this.iduser2 = iduser2;
        this.datematch = datematch;
        this.etat = etat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIduser1() {
        return iduser1;
    }

    public void setIduser1(String iduser1) {
        this.iduser1 = iduser1;
    }

    public String getIduser2() {
        return iduser2;
    }

    public void setIduser2(String iduser2) {
        this.iduser2 = iduser2;
    }

    public String getDatematch() {
        return datematch;
    }

    public void setDatematch(String datematch) {
        this.datematch = datematch;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Matchs() {
    }


}
