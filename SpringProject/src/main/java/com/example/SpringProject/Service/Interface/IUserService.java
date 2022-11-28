package com.example.SpringProject.Service.Interface;

import com.example.SpringProject.Entity.UserEntity;
import com.example.SpringProject.Model.User;

import java.util.List;

public interface IUserService {
    public List<User> getAllUser();
    public User findUserById(long id);
    public void saveUser(UserEntity userEntity);
    public void deleteUser(long id);
}
