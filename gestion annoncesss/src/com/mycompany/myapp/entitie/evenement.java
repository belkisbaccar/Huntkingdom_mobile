/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author hazem
 */
public class evenement {
    private int id_event;
    private String titre_event;
     private String description_event;
    private String image;
    private String date_debut_event;
    private String date_fin_event;
    private int nb_place_event;
    private int nb;
    private int idUser;
    private int etat;
   

    public evenement() {
    }

    public evenement(int id_event, String titre_event, String description_event, String image, String date_debut_event, String date_fin_event, int nb_place_event, int nb, int idUser, int etat) {
        this.id_event = id_event;
        this.titre_event = titre_event;
        this.description_event = description_event;
        this.image = image;
        this.date_debut_event = date_debut_event;
        this.date_fin_event = date_fin_event;
        this.nb_place_event = nb_place_event;
        this.nb = nb;
        this.idUser = idUser;
        this.etat = etat;
    }

    public evenement(String titre_event, String description_event, String image, String date_debut_event, String date_fin_event, int nb_place_event, int nb, int idUser, int etat) {
        this.titre_event = titre_event;
        this.description_event = description_event;
        this.image = image;
        this.date_debut_event = date_debut_event;
        this.date_fin_event = date_fin_event;
        this.nb_place_event = nb_place_event;
        this.nb = nb;
        this.idUser = idUser;
        this.etat = etat;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

 

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getTitre_event() {
        return titre_event;
    }

    public void setTitre_event(String titre_event) {
        this.titre_event = titre_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate_debut_event() {
        return date_debut_event;
    }

    public void setDate_debut_event(String date_debut_event) {
        this.date_debut_event = date_debut_event;
    }

    public String getDate_fin_event() {
        return date_fin_event;
    }

    public void setDate_fin_event(String date_fin_event) {
        this.date_fin_event = date_fin_event;
    }

    public int getNb_place_event() {
        return nb_place_event;
    }

    public void setNb_place_event(int nb_place_event) {
        this.nb_place_event = nb_place_event;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id_event;
        hash = 71 * hash + Objects.hashCode(this.titre_event);
        hash = 71 * hash + Objects.hashCode(this.description_event);
        hash = 71 * hash + Objects.hashCode(this.image);
        hash = 71 * hash + Objects.hashCode(this.date_debut_event);
        hash = 71 * hash + Objects.hashCode(this.date_fin_event);
        hash = 71 * hash + this.nb_place_event;
        hash = 71 * hash + this.nb;
        hash = 71 * hash + this.idUser;
        hash = 71 * hash + this.etat;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final evenement other = (evenement) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        if (!Objects.equals(this.titre_event, other.titre_event)) {
            return false;
        }
        if (!Objects.equals(this.description_event, other.description_event)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.date_debut_event, other.date_debut_event)) {
            return false;
        }
        if (!Objects.equals(this.date_fin_event, other.date_fin_event)) {
            return false;
        }
        if (this.nb_place_event != other.nb_place_event) {
            return false;
        }
        if (this.nb != other.nb) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.etat != other.etat) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "evenement{" + "id_event=" + id_event + ", titre_event=" + titre_event + ", description_event=" + description_event + ", image=" + image + ", date_debut_event=" + date_debut_event + ", date_fin_event=" + date_fin_event + ", nb_place_event=" + nb_place_event + ", nb=" + nb + ", idUser=" + idUser + ", etat=" + etat + '}';
    }

 

   

    

   
    
}
