package com.searchhouse.searchhouse.controllers;



import com.searchhouse.searchhouse.entities.Agent;
import com.searchhouse.searchhouse.entities.Logement;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.repositories.AgentRepository;
import com.searchhouse.searchhouse.repositories.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;


    // Create a new Agent

    @PostMapping("/agent")
    public Agent createAgent(@Valid @RequestBody Agent agent){

        return agentRepository.save(agent);
    }

    //Update logement

    @PutMapping("/agent/{id}")

    public  Agent updateAgent(@PathVariable(value="id") Long Id,
                                    @Valid @RequestBody Agent agentDetails){

        Agent agent = agentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Logement","id", Id));

        agent.setNom(agentDetails.getNom());
        agent.setPrenom(agentDetails.getPrenom());
        agent.setMail(agentDetails.getMail());
        agent.setSociete(agentDetails.getSociete());
        agent.setPsswd(agentDetails.getPsswd());
        agent.setTelephone(agentDetails.getTelephone());
        agent.setUserName(agentDetails.getUserName());
        agent.setVille(agentDetails.getVille());

        Agent updateAgent =agentRepository.save(agent);

        return updateAgent;
    }


    @GetMapping("/agent/{id}")
    public Agent getAgentById(@PathVariable(value = "id") Long Id) {
        return agentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Logement","id",Id));
    }

    @GetMapping("/agent/{id}/logements")
    public List<Logement> retrieveAllLogement(@PathVariable(value = "id") Long Id) {
        Agent agent = getAgentById(Id);
        return agent.getLogements();
    }





}
