/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities.Annonces;

/**
 *
 * @author abdelhamid
 */
public class Annonce {
    private int id_annonce;
    private String text;
    private String image;
    private String aime;
    private String etat;
    private String id_user;
    private int username;

    public Annonce(String text, String image, String aime, String etat, String id_user) {
        this.text = text;
        this.image = image;
        this.aime = aime;
        this.etat = etat;
        this.id_user = id_user;
    }

    public Annonce(String text, String image, String id_user) {
        this.text = text;
        this.image = image;
        this.id_user = id_user;
    }

   

    
    
    
    public Annonce() {
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public String getAime() {
        return aime;
    }

    public String getEtat() {
        return etat;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAime(String aime) {
        this.aime = aime;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id_annonce=" + id_annonce + ", text=" + text + ", image=" + image + ", aime=" + aime + ", etat=" + etat + ", id_user=" + id_user + '}';
    }
    
    
}
