package com.searchhouse.searchhouse.service;

import com.searchhouse.searchhouse.entities.User;
import com.searchhouse.searchhouse.exception.EmailExistsException;
import com.searchhouse.searchhouse.exception.RessourcesNotFoundException;
import com.searchhouse.searchhouse.model.UserRegistration;

public interface IUserService {

    User registerNewUserAccount(UserRegistration accountRegistration)
        throws EmailExistsException;
}
