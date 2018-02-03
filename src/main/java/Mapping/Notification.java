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
    private String idaction;
    private String idpub;
    private String daty;

    public Notification() {

    }

    public Notification(String id, String idaction, String idpub, String daty) {
        this.id = id;
        this.idaction = idaction;
        this.idpub = idpub;
        this.daty = daty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdaction() {
        return idaction;
    }

    public void setIdaction(String idaction) {
        this.idaction = idaction;
    }

    public String getIdpub() {
        return idpub;
    }

    public void setIdpub(String idpub) {
        this.idpub = idpub;
    }

    public String getDaty() {
        return daty;
    }

    public void setDaty(String daty) {
        this.daty = daty;
    }

    

}
