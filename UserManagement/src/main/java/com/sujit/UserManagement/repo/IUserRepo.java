package com.sujit.UserManagement.repo;

import com.sujit.UserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {
    Optional<User> findById(Integer id);

}
