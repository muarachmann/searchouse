package com.searchhouse.searchhouse.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "logements")

public class Logement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "type")
    private String type;

    @NotNull
    @Column(name = "latitude")
    private String latitude;

    @NotNull
    @Column(name = "longitude")
    private String longitude;

    @NotNull
    @Column(name = "prix")
    private Double prix;

    @NotNull
    @Column(name = "piece")
    private String piece;

    @NotNull
    @Column(name = "ville")
    private String ville;

    @NotNull
    @Column(name = "quartier")
    private String quartier;

    @NotNull
    @Column(name = "photo")
    private String photo;

    @NotNull
    @Column(name = "status")
    private Boolean status;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false , insertable = false , updatable = false)
    @JsonIgnore
    private User user;

    public Logement(){
        super();
    }

    public Logement(@NotNull String type, @NotNull String latitude, @NotNull String longitude, @NotNull Double prix, @NotNull String piece, @NotNull String ville, @NotNull String quartier, @NotNull String photo, @NotNull Boolean status) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.prix = prix;
        this.piece = piece;
        this.ville = ville;
        this.quartier = quartier;
        this.photo = photo;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLatitude() {
        return  latitude;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
