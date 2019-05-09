package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.entities.Logement;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.repositories.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

}
