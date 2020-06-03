/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities.fosUser;

import java.util.Date;

/**
 *
 * @author belkis
 */
public class Reponse {
    private int id_reponse;
    private int id_reclamation;
    private String contenu;
    private String image;
    private Date date;

    public Reponse(String contenu, String image) {
        this.contenu = contenu;
        this.image = image;
    }

    public Reponse() {
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_reponse + ", id_reclamation=" + id_reclamation + ", contenu=" + contenu + ", image=" + image + ", date=" + date + '}';
    }
    
    
}
