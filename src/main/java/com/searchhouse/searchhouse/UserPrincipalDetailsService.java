package com.searchhouse.searchhouse;

import com.searchhouse.searchhouse.db.UserRepository;
import com.searchhouse.searchhouse.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository  userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        } else {
            UserPrincipal userPrincipal = new UserPrincipal(user);
            return userPrincipal;
        }
    }
}
