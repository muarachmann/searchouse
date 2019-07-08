package com.searchhouse.searchhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class LogementSearch {

    private Long id;
    private String type;
    private String latitude;
    private String longitude;
    private Double prix;
    private String piece;
    private String ville;
    private String quartier;
    private String photo;
    private User user;

    public LogementSearch(){
        super();
    }

    public LogementSearch(Long id, String type, String latitude, String longitude, Double prix, String piece,
            String ville, String quartier, String photo, User user) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.prix = prix;
        this.piece = piece;
        this.ville = ville;
        this.quartier = quartier;
        this.photo = photo;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
