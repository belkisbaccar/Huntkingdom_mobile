/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Produit;

import java.util.Objects;

/**
 *
 * @author azizm
 */
public class produit_entities {
    public String nom;
    public int quantite;
    public String image;
    public int prix;
    public float prix_promo;

  produit_entities(){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public float getPrix_promo() {
        return prix_promo;
    }

    public void setPrix_promo(float prix_promo) {
        this.prix_promo = prix_promo;
    }
    

    public produit_entities(String nom, int quantite, String image,int prix, float prix_promos) {
        this.nom = nom;
        this.quantite = quantite;
        this.image = image;
        this.prix=prix;
        this.prix_promo=prix_promo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nom);
        hash = 59 * hash + Objects.hashCode(this.quantite);
        hash = 59 * hash + Objects.hashCode(this.image);
         hash = 59 * hash + Objects.hashCode(this.prix);
          hash = 59 * hash + Objects.hashCode(this.prix_promo);
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
        final produit_entities other = (produit_entities) obj;
        return true;
    }

    @Override
    public String toString() {
        return "produit_entities{" + "nom=" + nom + ", quantite=" + quantite + ", image=" + image + ", prix=" + prix + ", prix_promo=" + prix_promo + '}';
    }

   
    
}
