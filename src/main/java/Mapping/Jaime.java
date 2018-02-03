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
public class Jaime {

    private String id;
    private String idUser;
    private String idPub;

    public Jaime() {
    }

    public Jaime(String id, String idUser, String idPub) {
        this.id = id;
        this.idUser = idUser;
        this.idPub = idPub;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdPub() {
        return idPub;
    }

    public void setIdPub(String idPub) {
        this.idPub = idPub;
    }

}
