package com.searchhouse.searchhouse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class LogementSearch {

    private String agentname;
    private String agentemail;
    private Long id;
    private String type;
    private Long ida;
    private String latitude;
    private String longitude;
    private String prix;
    private String piece;
    private String ville;
    private String quartier;
    private String photo;

    public LogementSearch(){
        super();
    }

    public LogementSearch(
            Long id,
            String type,
            String latitude,
            String longitude,
            String prix,
            String piece,
            String ville,
            String quartier,
            String photo,
            Long ida,
            String agentname,
            String agentemail) {
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.prix = prix;
        this.piece = piece;
        this.ville = ville;
        this.quartier = quartier;
        this.photo = photo;
        this.ida = ida;
        this.agentname = agentname;
        this.agentemail = agentemail;
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

    public Long getIda() {
        return ida;
    }

    public void setIda(Long ida) {
        this.ida = ida;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getAgentemail() {
        return agentemail;
    }

    public void setAgentemail(String agentemail) {
        this.agentemail = agentemail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
