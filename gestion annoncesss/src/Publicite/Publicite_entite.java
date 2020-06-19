/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publicite;

import java.util.Objects;

/**
 *
 * @author walid
 */
public class Publicite_entite {
    int id;
    String nom;
    String image;
    int position;
    int etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Publicite_entite{" + "id=" + id + ", nom=" + nom + ", image=" + image + ", position=" + position + ", etat=" + etat + '}';
    }

 

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicite_entite other = (Publicite_entite) obj;
        if (this.position != other.position) {
            return false;
        }
        if (this.etat != other.etat) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
    
    
}
