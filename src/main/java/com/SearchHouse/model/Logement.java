package com.SearchHouse.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Table(name = "Logement")
@Entity
//@JsonFilter("")
@EntityListeners(AuditingEntityListener.class)
public class Logement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name="idAgent")
    /*private Agent agent;
    public void setAgent(Agent a) {agent = a;}
    public Artiste getAgent() {return agent;}
*/
    private int idLog ;


    @NotBlank
    @Column(nullable = false, length = 20)
    public String type;

    @NotBlank
    @Column(nullable = false, length = 20)
    public String ville;

    @NotBlank
    @Column(nullable = false, length = 255)
    public String latitude;

    @NotBlank
    @Column(nullable = false, length = 255)
    public String longitude;

    @NotBlank
    @Column(nullable = false, length = 2)
    public String piece;

    @NotBlank
    @Column(nullable = false, length = 30)
    public String quatier;

    @NotBlank
    @Column(nullable = false, length = 10)
    public String prix;


    public Logement()  {
    }

    public Logement(String type, String ville, String latitude, String longitude, String piece, String quatier, String prix) {
        this.type = type;
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;
        this.piece = piece;
        this.quatier = quatier;
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getQuatier() {
        return quatier;
    }

    public void setQuatier(String quatier) {
        this.quatier = quatier;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
