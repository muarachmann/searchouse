package com.searchhouse.searchhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "confirmation_token", nullable = false)
    private String confirmation_token;

    private String roles = "";

    private String permissions = "";

    @Column(name = "photo", nullable = true)
    private String photo;

    @OneToMany(targetEntity = Logement.class, mappedBy="user", cascade=CascadeType.ALL , fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Logement> logements = new ArrayList<>();

    @OneToOne(targetEntity = AgentDetails.class, mappedBy = "user", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private AgentDetails agentDetails;

    protected User(){}

    public User(String username, String nom, String prenom, String email, String telephone, String password, String photo, boolean active, String confirmation_token,
                String roles, String permissions) {
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.active = active;
        this.confirmation_token = confirmation_token;
        this.roles = roles;
        this.permissions = permissions;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public String getRoles() {
        return roles;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public AgentDetails getAgentDetails() {
        return agentDetails;
    }

    public void setAgentDetails(AgentDetails agentDetails) {
        this.agentDetails = agentDetails;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public List<Logement> getLogements() {
        return logements;
    }

    public void setLogements(List<Logement> logements) {
        this.logements = logements;
    }

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}
