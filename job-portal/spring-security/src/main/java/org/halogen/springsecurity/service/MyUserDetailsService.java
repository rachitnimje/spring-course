package org.halogen.springsecurity.service;

import org.halogen.springsecurity.dao.UserRepo;
import org.halogen.springsecurity.model.User;
import org.halogen.springsecurity.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);

        if(user == null){
            System.out.println("404 User Not Found");
            throw new UsernameNotFoundException(username);
        }

        return new UserPrincipal(user);
    }
}
