package com.searchhouse.searchhouse.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "agent")
public class Agent {

    @OneToMany(targetEntity=Logement.class, mappedBy="agent",cascade=CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnore

    private List<Logement> logements = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    public String nom;

    @NotNull
    public String username;

    @NotNull
    public String psswd;

    @NotNull
    public String prenom;

    @NotNull
    public String mail;

    @NotNull
    public String telephone;

    @NotNull
    public String societe;

    @NotNull
    public String ville;


    public Agent() {
        super();
    }

    public Agent(@NotNull String nom, @NotNull String username, @NotNull String psswd, @NotNull String prenom, @NotNull String mail, @NotNull String telephone, @NotNull String societe, @NotNull String ville) {
        this.nom = nom;
        this.username = username;
        this.psswd = psswd;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.societe = societe;
        this.ville=ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }


    public List<Logement> getLogements() {
        return logements;
    }

    public void setLogements(List<Logement> logements) {
        this.logements = logements;
   }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
