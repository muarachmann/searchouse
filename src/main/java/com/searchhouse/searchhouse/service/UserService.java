package com.searchhouse.searchhouse.service;

import com.searchhouse.searchhouse.model.User;
import com.searchhouse.searchhouse.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public boolean findByEmailAndUsernameAndTelephone(String param) {
        User user = userRepository.findByEmailAndUsernameAndTelephone(param);
        boolean userExist = false;
        if(user != null){ userExist = true; }
        return  userExist;
    }

    public User getUserDetails(String email){
        return userRepository.findByEmailAndUsernameAndTelephone(email);
    }

    public User findByConfirmationToken(String confirmationToken){

        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public User createNewUser(User user){
        userRepository.save(user);
        return user;
    }

}

