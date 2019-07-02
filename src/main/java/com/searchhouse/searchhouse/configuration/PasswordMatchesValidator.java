package com.searchhouse.searchhouse.configuration;

import com.searchhouse.searchhouse.model.UserRegistration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches,Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        UserRegistration user= (UserRegistration) obj ;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
