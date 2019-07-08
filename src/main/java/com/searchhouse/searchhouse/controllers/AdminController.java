package com.searchhouse.searchhouse.controllers;

import com.searchhouse.searchhouse.db.LogementRepository;
import com.searchhouse.searchhouse.db.UserRepository;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.model.Logement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;


    // ******************************************************************* //
    //                 ADMIN ROUTE GOES HERE                             //
    // ****************************************************************** //

    @GetMapping("/admin/index")
    public String getAdminIndex(Model model, Principal principal) {
        if(principal != null){
            model.addAttribute("agent",  principal.getName());
        }
        return "admin/index";
    }


}
