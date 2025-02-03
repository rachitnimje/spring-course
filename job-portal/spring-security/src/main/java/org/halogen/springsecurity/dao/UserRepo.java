package org.halogen.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.halogen.springsecurity.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
