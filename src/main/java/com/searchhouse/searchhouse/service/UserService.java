package com.searchhouse.searchhouse.service;

import com.searchhouse.searchhouse.entities.User;
import com.searchhouse.searchhouse.exception.EmailExistsException;
import com.searchhouse.searchhouse.exception.RessourcesNotFoundException;
import com.searchhouse.searchhouse.model.UserRegistration;
import com.searchhouse.searchhouse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService  {

       private UserRepository userRepository;

    @Autowired
     public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public User findByConfirmationToken(String confirmationToken){

        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
    }

