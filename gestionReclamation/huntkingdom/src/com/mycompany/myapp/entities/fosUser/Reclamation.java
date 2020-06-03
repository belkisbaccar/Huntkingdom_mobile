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
public class Reclamation {
    private int id_reclamation;
    private String etat;
    private String description;
    private String image;
    private int note;
    private int id_annonce_reclame;
    private int id_user;
    private Date date;
    private int id_produit;
    private int priority;
    private String file;

    public Reclamation() {
    }

    public Reclamation(int id_reclamation, String description) {
        this.id_reclamation = id_reclamation;
        this.description = description;
    }

   

    public Reclamation(String etat, String description, String image, int note, int id_annonce_reclame, int id_user, Date date, int id_produit, int priority) {
        this.etat = etat;
        this.description = description;
        this.image = image;
        this.note = note;
        this.id_annonce_reclame = id_annonce_reclame;
        this.id_user = id_user;
        this.date = date;
        this.id_produit = id_produit;
        this.priority = priority;
    }

    public Reclamation(String description, String image) {
        this.description = description;
        this.image = image;
    }

    public Reclamation(String etat, String description, String image, int note, int id_user, int id_produit, int priority) {
        this.etat = etat;
        this.description = description;
        this.image = image;
        this.note = note;
        this.id_user = id_user;
        this.id_produit = id_produit;
        this.priority = priority;
    }

    public Reclamation(int id_reclamation, String description, String image, int id_user, int id_produit) {
        this.id_reclamation = id_reclamation;
        this.description = description;
        this.image = image;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    public Reclamation(String description, String file, int id_user, int id_produit) {
        this.description = description;
        this.file = file;
        this.id_user = id_user;
        this.id_produit = id_produit;
    }

    

   
    

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public int getId_annonce_reclame() {
        return id_annonce_reclame;
    }

    public void setId_annonce_reclame(int id_annonce_reclame) {
        this.id_annonce_reclame = id_annonce_reclame;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFile() {
        return file;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", etat=" + etat + ", description=" + description + ", image=" + image + ", note=" + note + ", id_annonce_reclame=" + id_annonce_reclame + ", id_user=" + id_user + ", date=" + date + ", id_produit=" + id_produit + ", priority=" + priority + ", file=" + file + '}';
    }

    
}
