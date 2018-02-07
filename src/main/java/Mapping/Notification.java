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
public class Notification {

    private String id;
    private String idUser;
    private String idUserPost; 
    private String action;
    private String idPub;
    private String daty;

    public Notification(String id, String idUser, String idUserPost, String action, String idPub, String daty) {
        this.id = id;
        this.idUser = idUser;
        this.idUserPost = idUserPost;
        this.action = action;
        this.idPub = idPub;
        this.daty = daty;
    }
    
    

    public String getIdUserPost() {
        return idUserPost;
    }

    public void setIdUserPost(String idUserPost) {
        this.idUserPost = idUserPost;
    }

  

    public Notification() {
    }

    public String getId() {
        return id;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getAction() {
        return action;
    }

    public String getIdPub() {
        return idPub;
    }

    public String getDaty() {
        return daty;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setIdPub(String idPub) {
        this.idPub = idPub;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }
    
    
}
