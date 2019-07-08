package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.db.UserRepository;
import com.searchhouse.searchhouse.model.Logement;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.db.LogementRepository;
import com.searchhouse.searchhouse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.management.resources.agent;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogementRepository logementRepository;

    // ******************************************************************* //
    //                 AGENTS ROUTE GOES HERE                             //
    // ****************************************************************** //

//    @GetMapping("/agent/{agent_id}")
//    public ModelAndView getAgentDashboard(@PathVariable(value = "agent_id") String username) {
//        Agent agent = agentRepository.findByEmailAndUsernameAndTelephone(username);
//        if(agent == null){
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("index.html");
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("dashboard/agents/index.html");
//            modelAndView.addObject("agent", agent);
//            return modelAndView;
//        }
//    }

    // ******************************************************************* //
    // ONLY AGENTS CAN CREATE/EDIT/UPDATE AND  CREATE THEIR LOGEMENTS HERE //
    // ****************************************************************** //

    // NB THIS IS PERFORMED BY AN AGENT ONLY

    // AGENT CREATE LOGEMENT
    @PostMapping("/agent/{agent_id}/logements/create")
    public String createLogement(@Valid @RequestBody Logement logement, @PathVariable(value= "agent_id") String username){

        logementRepository.save(logement);
        return "agents";
    }

    //AGENT DELETE A LOGEMENT
    @DeleteMapping("/agent/{agent_id}/logements/{logement_id}")
    public ResponseEntity<?> deleteLogement(@PathVariable(value = "id") Long Id){

        Logement logement = logementRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", Id));

        logementRepository.delete(logement);
        return  ResponseEntity.ok().build() ;

    }

    //AGENT UPDATE INFO ABOUT LOGEMENT
    @PutMapping("/agent/{agent_id}/logements/{logement_id}")
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

    //SHOW DETAILS OF LOGMENT TO AGENT
    @GetMapping("/agent/{agent_id}/logements/{logement_id}")
    public Logement getLogementById(@PathVariable(value ="id") Long Id){
        return logementRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Logement","id",Id));
    }


}
