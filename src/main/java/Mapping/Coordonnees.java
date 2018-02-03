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
public class Coordonnees {

    private String id;
    private String idmatch;
    private String idutilisateur;
    private int x;
    private int y;
    private String types;
    private int point;

    public Coordonnees() {
    }

    public Coordonnees(String id, String idmatch, String idutilisateur, int x, int y, String types, int point) {
        this.id = id;
        this.idmatch = idmatch;
        this.idutilisateur = idutilisateur;
        this.x = x;
        this.y = y;
        this.types = types;
        this.point = point;
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

    public String getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(String idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

   
}
