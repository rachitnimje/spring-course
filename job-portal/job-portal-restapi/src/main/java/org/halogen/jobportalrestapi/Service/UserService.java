package org.halogen.jobportalrestapi.Service;

import org.halogen.jobportalrestapi.Model.User;
import org.halogen.jobportalrestapi.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return userRepo.findByUsername(user.getUsername());
    }
}
