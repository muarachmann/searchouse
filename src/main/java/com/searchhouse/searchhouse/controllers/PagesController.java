package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.entities.Agent;
import com.searchhouse.searchhouse.model.UserRegistration;
import com.searchhouse.searchhouse.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.management.resources.agent;

import javax.validation.Valid;


@Controller
public class PagesController {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgentController agentController;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/")
    public ModelAndView getHomePage() {
        Agent agent = agentRepository.getAgentByUserName("muarachmann2");
        return new ModelAndView("index","agent", agent);
    }

    @GetMapping("/about")
    public ModelAndView getAboutPage() {
        return new ModelAndView("about");
    }

    @GetMapping("/contact")
    public ModelAndView getContactPage() {
        return new ModelAndView("contact");
    }


    // Connexion pour l'utilisateur et l'agent
    @PostMapping("/login/useragent")
    public ModelAndView loginUserAgent(
            @Valid
            @RequestParam
                    String username,
                    String password,
                    String user_type){

        if(user_type.equalsIgnoreCase("agent")){
            // user is an agent check in the agent redirect to agent login controller
        } else {
            // user is a normal user do the user login here or redirect to user login controller
        }
        return new ModelAndView("index");
    }


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("register","user", new UserRegistration());
    }


    // Eregistrer pour l'utilisateur et l'agent
    @PostMapping("/register")
    public ModelAndView registerUserAgent(
            @Valid
            @RequestParam
                    String username,
            String password,
            String user_type, Model model){

        if(user_type.equalsIgnoreCase("agent")){
            // user is an agent check in the agent redirect to agent register controller

            Agent agent = new Agent();
            agent.username = username;
            agent.mail = "test@gmail.com";
            agent.nom = "nom";
            agent.prenom = "prenom";
            agent.psswd = bCryptPasswordEncoder.encode(password);;
            agent.societe = "GICAM";
            agent.telephone = "+23670518086";
            agent.ville = "Douala";
            agentController.createAgent(agent);
            System.out.println(agent);
            model.addAttribute("agent", agent);

        } else {
            // user is a normal user do the user login here or redirect to user register controller
        }
        return new ModelAndView("index");
    }


}
