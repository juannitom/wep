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
public class Resultats {

    private String id;
    private String idmatch;
    private int resultat1;
    private int resultat2;
    private String gagnant;

    public Resultats(String id, String idmatch, int resultat1, int resultat2, String gagnant) {
        this.id = id;
        this.idmatch = idmatch;
        this.resultat1 = resultat1;
        this.resultat2 = resultat2;
        this.gagnant = gagnant;
    }

    public Resultats() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(String idmatch) {
        this.idmatch = idmatch;
    }

    public int getResultat1() {
        return resultat1;
    }

    public void setResultat1(int resultat1) {
        this.resultat1 = resultat1;
    }

    public int getResultat2() {
        return resultat2;
    }

    public void setResultat2(int resultat2) {
        this.resultat2 = resultat2;
    }

    public String getGagnant() {
        return gagnant;
    }

    public void setGagnant(String gagnant) {
        this.gagnant = gagnant;
    }

}
