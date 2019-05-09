package com.searchhouse.searchhouse.controllers;



import com.searchhouse.searchhouse.entities.Agent;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.repositories.AgentRepository;
import com.searchhouse.searchhouse.repositories.LogementRepository;
import org.springframework.beans.factory.annotation.Autowired;
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




}
