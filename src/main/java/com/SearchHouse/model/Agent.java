package com.SearchHouse.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Table(name="Agent")
@Entity
public class Agent {

    @Id
    @GeneratedValue
    private int IdAgent;

    public String Nom;
    public String Prenom;
    public String passwd;
    public String Ville;
    public String Societe;

    public Agent() {
    }

    public Agent(String nom, String prenom, String passwd, String ville, String societe) {
        Nom = nom;
        Prenom = prenom;
        this.passwd = passwd;
        Ville = ville;
        Societe = societe;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getSociete() {
        return Societe;
    }

    public void setSociete(String societe) {
        Societe = societe;
    }
}
