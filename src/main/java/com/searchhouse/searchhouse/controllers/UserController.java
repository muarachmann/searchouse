package com.searchhouse.searchhouse.controllers;



import com.searchhouse.searchhouse.entities.User;
import com.searchhouse.searchhouse.exception.ResourceNotFoundException;
import com.searchhouse.searchhouse.exception.RessourcesNotFoundException;
import com.searchhouse.searchhouse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create a new User
    @PostMapping("/searchouse/user")
    public User createUser(@Valid @RequestBody User user) {
        User user2 = userRepository.creationUser(user.getUsername());
        if (user2 == null) {
            return userRepository.save(user);}
        else{
            throw new RessourcesNotFoundException("Cet username existe déjà");
        }
    }

    @PostMapping("/searchouse/user/connexion")
    public User connexion(@Valid @RequestParam String name, String psswd){
        return userRepository.connexionUser(name, psswd);
    }


    @PutMapping("/searchouse/user/{id}")

    public  User updateUser(@PathVariable(value="id") Long Id,
                              @Valid @RequestBody User userDetails){

        User user = userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User","id", Id));

        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setTelephone(userDetails.getTelephone());
        user.setUsername(userDetails.getUsername());

        User updateUser = userRepository.save(user);

        return updateUser;
    }


   /* // Delete a User
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long Id) {
        User user = userRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", Id));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
*/
}
