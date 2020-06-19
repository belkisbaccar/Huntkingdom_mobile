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
public class newsletter_entite {
    int id;
    int id_user;
    int etat;
    String mail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "newsletter_entite{" + "id=" + id + ", id_user=" + id_user + ", etat=" + etat + ", mail=" + mail + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.id_user;
        hash = 37 * hash + this.etat;
        hash = 37 * hash + Objects.hashCode(this.mail);
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
        final newsletter_entite other = (newsletter_entite) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.etat != other.etat) {
            return false;
        }
        if (!Objects.equals(this.mail, other.mail)) {
            return false;
        }
        return true;
    }
    
    
}
