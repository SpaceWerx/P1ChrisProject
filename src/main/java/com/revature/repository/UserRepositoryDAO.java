package com.revature.repository;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;

public interface UserRepositoryDAO
{
	//Get User byID
    User findByUserId(int id);
    
	//Get User by name
    User findByUserName(String userName);
    
    //Get All Users
    List<User> findAll();
    
    //Get Users list by Role
    List<User> findUsersByRole(Role userRole);
    
    //Create new User
    int createUser(User user);
   
}
