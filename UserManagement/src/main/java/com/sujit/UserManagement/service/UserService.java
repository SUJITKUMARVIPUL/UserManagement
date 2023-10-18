package com.sujit.UserManagement.service;

import com.sujit.UserManagement.model.UpdateType;
import com.sujit.UserManagement.model.User;
import com.sujit.UserManagement.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    public String addUser(List<User> newUser){
        userRepo.saveAll(newUser);
        return "User Added Successfully";
    }

    public Optional<User> getUserById(Integer Id){
        return userRepo.findById(Id);
    }

    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    public String deleteById(Integer id){
        userRepo.deleteById(id);
        return "User Removed Successfully";
    }

    public String updateUser(Integer Id,UpdateType type,String newValue){
        User user = userRepo.getReferenceById(Id);
        if(type.equals(UpdateType.email)){
            user.setEmail(newValue);
            userRepo.save(user);
            return "Email updated successfully";
        }else if(type.equals(UpdateType.userName)){
            user.setUserName(newValue);
            userRepo.save(user);
            return "Name updated successfully";
        } else if (type.equals(UpdateType.phoneNumber)) {
            user.setPhoneNumber(newValue);
            userRepo.save(user);
            return "Phone Number updated successfully";
        }
        return "something went wrong";
    }

}
