package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.UserPrincipal;
import com.searchhouse.searchhouse.model.AgentDetails;
import com.searchhouse.searchhouse.model.User;

import com.searchhouse.searchhouse.service.UserService;
import com.searchhouse.searchhouse.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;


@Controller
public class PagesController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String getHomePage(Model model, Principal principal) {
        if(principal != null){
            model.addAttribute("agent",  principal.getName());
        }
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return "contact";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model, String error, String success){
        if(error != null){
            model.addAttribute("error", error);
        }
        if(success != null){
            model.addAttribute("success", success);
        }
        return "register";
    }


    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String postLogin(Model model, HttpSession session) {
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = ((UserPrincipal) authentication.getPrincipal()).getUserDetails();
        model.addAttribute("currentUser", loggedInUser.getUsername());
        session.setAttribute("userId", loggedInUser.getId());
        return "redirect:/wallPage";
    }


    @PostMapping("/register")
    public String registerUser(
            @Valid
            @RequestParam
            String username,
            String nom, String prenom,
            String email, String telephone,
            String password, String user_type, String societe, String ville, String apropos,
            RedirectAttributes redirectAttributes, HttpServletRequest request){

        boolean userExistsByEmail = userService.findByEmailAndUsernameAndTelephone(email);
        boolean userExistsByUsername = userService.findByEmailAndUsernameAndTelephone(username);
        boolean userExistsByTelephone = userService.findByEmailAndUsernameAndTelephone(telephone);

        if(userExistsByEmail || userExistsByTelephone || userExistsByUsername){
            String errorMessage = "";
            if(userExistsByEmail){
                errorMessage = "Sorry Email account already exists. Please use another email.";
            } else if (userExistsByUsername){
                errorMessage = "Sorry Username already exists. Please use another.";
            } else {
                errorMessage = "Sorry this telephone number belongs to an existing account. Please use another telephone.";
            }
            redirectAttributes.addFlashAttribute("error", errorMessage);
            return "redirect:/register";

        } else {
            User user;
            if(user_type.equalsIgnoreCase("agent")){
                AgentDetails agentDetails = new AgentDetails(ville, societe, "",apropos);

                user = new User(username, nom, prenom, email, telephone, this.passwordEncoder.encode(password), "", true, Utils.generatetoken(), "AGENT", "");
                user.setAgentDetails(agentDetails);     // Set child reference(agentDetails) in parent entity(user)
                agentDetails.setUser(user);             // Set parent reference(user) in child entity(agentDetails)
            } else {
                user = new User(username, nom, prenom, email, telephone, this.passwordEncoder.encode(password), "", true, Utils.generatetoken(), "USER", "");
            }
            userService.createNewUser(user);
            redirectAttributes.addFlashAttribute("success", "Your " + user_type +  " account is successfully setup! We sent an email to "+ email +". Please make sure to activate your account before.");
            // SendEmails sendEmails = new SendEmails();
            // sendEmails.sendMailtoUsers(request, newuser, newuser.confirmation_token);
            return "redirect:/register";
        }
    }

    @RequestMapping(value="/register/activate/user", method = RequestMethod.GET)
    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam String token){
        User user= userService.findByConfirmationToken(token);
        if(user == null){
            modelAndView.addObject("error","Sorry the link has expired. Please contact the admin.");
        }else {
            modelAndView.addObject("user", user);
        }
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    // ACTIVATE AGENT HERE


}



