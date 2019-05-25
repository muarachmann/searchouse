package com.searchhouse.searchhouse.controllers;



import com.searchhouse.searchhouse.entities.Agent;
import com.searchhouse.searchhouse.entities.Logement;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.exception.RessourcesNotFoundException;
import com.searchhouse.searchhouse.repositories.AgentRepository;
import com.searchhouse.searchhouse.repositories.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;


    // Create a new Agent

    @PostMapping("/searchouse/agent")
    public Agent createAgent(@Valid @RequestBody Agent agent) {

        Agent agent2 = agentRepository.creationAgent(agent.getUserName());
        if (agent2 == null) {
            return agentRepository.save(agent);}
            else{
             throw new RessourcesNotFoundException("Cet username existe déjà");
            }
        }



    //Update logement

    @PutMapping("/searchouse/agent/{id}")

    public  Agent updateAgent(@PathVariable(value="id") Long Id,
                                    @Valid @RequestBody Agent agentDetails){

        Agent agent = agentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent","id", Id));

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


    @GetMapping("/searchouse/agent/{id}")
    public Agent getAgentById(@PathVariable(value = "id") Long Id) {
        return agentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent","id",Id));
    }

    @GetMapping("/searchouse/agent/{id}/logements")
    public List<Logement> retrieveAllLogement(@PathVariable(value = "id") Long Id) {
        Agent agent = getAgentById(Id);
        return agent.getLogements();
    }


    @PostMapping("/searchouse/connexion")

    public Agent connexion(@Valid @RequestParam String name,String psswd){
        return agentRepository.connexionAgent(name, psswd);
    }

    // Delete a Agent
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long Id) {
        Agent agent = agentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent", "id", Id));

        agentRepository.delete(agent);

        return ResponseEntity.ok().build();
    }



}
