package com.searchhouse.searchhouse.controllers;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;
import com.searchhouse.searchhouse.entities.Agent;
import com.searchhouse.searchhouse.entities.User;
import com.searchhouse.searchhouse.exception.EmailExistsException;
import com.searchhouse.searchhouse.exception.RessourcesNotFoundException;
import com.searchhouse.searchhouse.model.UserRegistration;
import com.searchhouse.searchhouse.repositories.AgentRepository;
import com.searchhouse.searchhouse.service.EmailService;

import com.searchhouse.searchhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.management.resources.agent;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.Map;
import java.util.UUID;


@Controller
public class PagesController {

   @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgentController agentController;

    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EmailService emailService;


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
            agentController.connexionAgent(username,password);
        } else {
            // user is a normal user do the user login here or redirect to user login controller
            userController.connexion(username,password);
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
            /*
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
*/
           agentController.createAgent(agent);
        } else {
            User user = new User();
            // user is a normal user do the user login here or redirect to user register controller
        userController.createUser(user);
        }
        return new ModelAndView("index");
    }

    /*@RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request){

        User userExists = userService.findByEmail(user.getEmail());

        System.out.println(userExists);

        if(userExists != null){

            modelAndView.addObject("aldreadyRegisteredMessage" , "Oops ! There is  already a user registered with the email provided.");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if(bindingResult.hasErrors()){

            modelAndView.setViewName("register");
        }else {
            user.setConfirmationToken(UUID.randomUUID().toString());

            userService.saveUser(user);

            String appUrl =  request.getScheme() + "://" + request.getServerName();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("To confirm your email address, please click the link below:\n"
                        + appUrl + "/confirm?token=" + user.getConfirmationToken());

        }

            return modelAndView;
    }

*/
    @RequestMapping(value="/confirm",method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam String token){


        User user= userService.findByConfirmationToken(token);

        if(user == null){
            modelAndView.addObject("invalidToken","Oops ! This is an invalid confirmation link");

        }else {
            modelAndView.addObject("confirmationToken",user.getConfirmationToken());
        }

        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    //Process confirmation link

  /*  @RequestMapping(value="/confirm", method = RequestMethod.POST)
    public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {

        modelAndView.setViewName("confirm");

        Zxcvbn passwordCheck = new Zxcvbn();

        Strength strength = passwordCheck.measure(requestParams.get("password"));

        if (strength.getScore() < 3) {
            bindingResult.reject("password");

            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
            System.out.println(requestParams.get("token"));
            return modelAndView;
        }

        // Find the user associated with the reset token
        User user = userService.findByConfirmationToken(requestParams.get("token"));

        // Set new password
        user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

        // Set user to enabled
        user.setEnabled(true);

        // Save user
        userService.saveUser(user);

        modelAndView.addObject("successMessage", "Your password has been set!");
        return modelAndView;
    }
*/


    }



