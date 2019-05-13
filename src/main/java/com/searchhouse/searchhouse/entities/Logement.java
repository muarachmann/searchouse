package com.searchhouse.searchhouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "logement")

public class Logement {


    @ManyToOne()
    @JoinColumn(name = "ida", referencedColumnName = "id", nullable = false , insertable = false , updatable = false)
    @JsonIgnore
    private Agent agent;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String type;


    @NotNull
    private Long ida;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;


    @NotNull
    private String prix;

    @NotNull
    private String piece;

    @NotNull
    private String ville;

    @NotNull
    private String quartier;

    @NotNull
    private String photo;

    public Logement(){
        super();
    }

    public Logement(@NotNull String type, @NotNull String latitude, @NotNull String longitude, @NotNull String prix, @NotNull String piece, @NotNull String ville, @NotNull String quartier, @NotNull String photo,@NotNull Long ida) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.prix = prix;
        this.piece = piece;
        this.ville = ville;
        this.quartier = quartier;
        this.photo = photo;
        this.ida=ida;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
  }

    public Long getIda() {
        return ida;
    }

    public void setIda(Long ida) {
        this.ida = ida;
    }
}
