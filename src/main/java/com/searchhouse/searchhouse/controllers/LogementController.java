package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.entities.Logement;
import com.searchhouse.searchhouse.entities.LogementSearch;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.repositories.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogementController {

    @Autowired
    private LogementRepository logementRepository;


    @GetMapping("/logement")
    public List<Logement> retrieveAllStudents() {
        return logementRepository.findAll();
    }


    //Create logement
    @PostMapping("/logement")
    public Logement createLogement(@Valid @RequestBody Logement logement){
        return logementRepository.save(logement);
    }

    //Delete logement

    @DeleteMapping("/logement/{id}")
    public ResponseEntity<?> deleteLogement(@PathVariable(value = "id") Long Id){

        Logement logement = logementRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", Id));

        logementRepository.delete(logement);
        return  ResponseEntity.ok().build() ;

    }

    //Update logement

    @PutMapping("/logement/{id}")

    public  Logement updateLogement(@PathVariable(value="id") Long Id,
                                    @Valid @RequestBody Logement logementDetails){

        Logement logement = logementRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Logement","id", Id));

        logement.setType(logementDetails.getType());
        logement.setLatitude(logementDetails.getLatitude());
        logement.setLongitude(logementDetails.getLongitude());
        logement.setPiece(logementDetails.getPiece());
        logement.setPrix(logementDetails.getPrix());
        logement.setVille(logementDetails.getVille());
        logement.setQuartier(logementDetails.getQuartier());
        logement.setPhoto(logementDetails.getPhoto());

        Logement updateLogement =logementRepository.save(logement);

        return updateLogement;
    }

    //Get a single logement

    @GetMapping("logement/{id}")
    public Logement getLogementById(@PathVariable(value ="id") Long Id){
        return logementRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Logement","id",Id));

    }

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
                    logementsearch.getIda(),
                    logementsearch.getAgent().nom,
                    logementsearch.getAgent().mail,
                    logementsearch.getAgent().telephone,
                    logementsearch.getAgent().societe
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
                    logement1.getIda(),
                    logement1.getAgent().nom,
                    logement1.getAgent().mail,
                    logement1.getAgent().telephone,
                    logement1.getAgent().societe
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
                 logement1.getIda(),
                 logement1.getAgent().nom,
                 logement1.getAgent().mail,
                 logement1.getAgent().telephone,
                 logement1.getAgent().societe
         ));
     }
     return logementSearch;
 }

}
