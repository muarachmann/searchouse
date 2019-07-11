package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.model.Logement;
import com.searchhouse.searchhouse.model.LogementSearch;
import com.searchhouse.searchhouse.db.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LogementController {

    @Autowired
    private LogementRepository logementRepository;


    @GetMapping("/logement")
    public List<Logement> getAllLogements() {
        return logementRepository.findAll();
    }


    // TODO

    @GetMapping("/searchouse")

    public List<LogementSearch> searchLogementByMotCle(@Valid @RequestParam String q){
        List<Logement> logement = logementRepository.findLogementByVille(q);
        List<LogementSearch> logementSearches = new ArrayList<>();

        for (Logement logementsearch: logement) {
            logementSearches.add(new LogementSearch(
                    logementsearch.getId(),
                    logementsearch.getType(),
                    logementsearch.getLatitude(),
                    logementsearch.getLongitude(),
                    logementsearch.getPrix(),
                    logementsearch.getPiece(),
                    logementsearch.getVille(),
                    logementsearch.getQuartier(),
                    logementsearch.getPhoto(),
                    logementsearch.getUser()
            ));
        }
        return logementSearches;
    }

    @GetMapping("/searchouse/resultat")

    public List<LogementSearch> searchLogementByMot(@Valid @RequestParam String mot_cle){
        List<Logement> logement = logementRepository.findLogementsByCarectiristique(mot_cle);
        List<LogementSearch> logementSearch = new ArrayList<>();

        for (Logement logement1: logement) {
            logementSearch.add(new LogementSearch(
                    logement1.getId(),
                    logement1.getType(),
                    logement1.getLatitude(),
                    logement1.getLongitude(),
                    logement1.getPrix(),
                    logement1.getPiece(),
                    logement1.getVille(),
                    logement1.getQuartier(),
                    logement1.getPhoto(),
                    logement1.getUser()
            ));
        }
        return logementSearch;
    }

    @GetMapping("/searchouse/rechercheavance")

    public List<LogementSearch> searchLogementAvance(@Valid @RequestParam String type,String ville,String quartier,String piece,Double prix1 ,Double prix2){

     List<Logement> logement = logementRepository.rechercheavance(type,ville,quartier,piece,prix1,prix2 );
     List<LogementSearch> logementSearch = new ArrayList<>();

     for (Logement logement1: logement) {
         logementSearch.add(new LogementSearch(
                 logement1.getId(),
                 logement1.getType(),
                 logement1.getLatitude(),
                 logement1.getLongitude(),
                 logement1.getPrix(),
                 logement1.getPiece(),
                 logement1.getVille(),
                 logement1.getQuartier(),
                 logement1.getPhoto(),
                 logement1.getUser()
         ));
     }
     return logementSearch;
 }

}
