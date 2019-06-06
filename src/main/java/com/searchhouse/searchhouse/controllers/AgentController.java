package com.searchhouse.searchhouse.controllers;


import com.searchhouse.searchhouse.model.UserRegistration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.searchhouse.searchhouse.entities.Agent;
import com.searchhouse.searchhouse.entities.Logement;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.exception.RessourcesNotFoundException;
import com.searchhouse.searchhouse.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AgentController {

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @RequestMapping("/searchouse/welcome")
    public ModelAndView firstPage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value = "/searchouse/register",method = RequestMethod.GET)
    public ModelAndView register(){

        return new ModelAndView("registration","user", new UserRegistration());
    }

   @RequestMapping(value = "/searchouse/inscription", method = RequestMethod.POST)
    public ModelAndView processRegister(@ModelAttribute("user") UserRegistration userRegistrationObject) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        String encodedPassword = bCryptPasswordEncoder.encode(userRegistrationObject.getPassword());

        User user = new User(userRegistrationObject.getUsername(), encodedPassword, authorities);
        jdbcUserDetailsManager.createUser(user);
        return new ModelAndView("redirect:/searchouse/welcome");
    }


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


    @PostMapping("/searchouse/agent/connexion")
    public Agent connexionAgent(@Valid @RequestParam String name, String psswd){
        return agentRepository.connexionAgent(name, psswd);
    }

    // Delete a Agent
    @DeleteMapping("/agent/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable(value = "id") Long Id) {
        Agent agent = agentRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Agent", "id", Id));

        agentRepository.delete(agent);

        return ResponseEntity.ok().build();
    }



}
