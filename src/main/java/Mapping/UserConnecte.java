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
public class UserConnecte {
    private String id;
    private String idUser;

    public UserConnecte(String id, String idUser) {
        this.id = id;
        this.idUser = idUser;
    }

    public UserConnecte(String idUser) {
        this.idUser = idUser;
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
}
