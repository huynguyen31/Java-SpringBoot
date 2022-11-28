package com.example.SpringProject.Service;

import com.example.SpringProject.Entity.UserEntity;
import com.example.SpringProject.Model.User;
import com.example.SpringProject.Repository.UserRepository;
import com.example.SpringProject.Service.Interface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        List<UserEntity> listUserEntity = userRepository.findAll();
        for (UserEntity userEntity : listUserEntity){
            User user = new User(userEntity);
            listUser.add(user);
        }
        return listUser;
    }

    @Override
    public User findUserById(long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        User user = new User(userEntity.get());
        return user;
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
