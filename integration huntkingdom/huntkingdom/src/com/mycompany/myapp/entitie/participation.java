/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entitie;

import java.util.Objects;

/**
 *
 * @author hazem
 */
public class participation {
    private int id_participation;
    private String username;
    private int id_event;
    private String dateReservation;

    public participation() {
    }

    public participation(int id_participation, String username, int id_event, String dateReservation) {
        this.id_participation = id_participation;
        this.username = username;
        this.id_event = id_event;
        this.dateReservation = dateReservation;
    }

    public participation(String username, int id_event, String dateReservation) {
        this.username = username;
        this.id_event = id_event;
        this.dateReservation = dateReservation;
    }

    public int getId_participation() {
        return id_participation;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id_participation;
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Objects.hashCode(this.id_event);
        hash = 59 * hash + Objects.hashCode(this.dateReservation);
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
        final participation other = (participation) obj;
        if (this.id_participation != other.id_participation) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (this.id_event != other.id_event) {
            return false;
        }
        if (!Objects.equals(this.dateReservation, other.dateReservation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "participation{" + "id_participation=" + id_participation + ", username=" + username + ", id_event=" + id_event + ", dateReservation=" + dateReservation + '}';
    }
    
    
}
